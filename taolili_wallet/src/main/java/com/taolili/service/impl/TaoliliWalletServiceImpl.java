package com.taolili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taolili.constant.TranceCodeConstant;
import com.taolili.domain.TaoliliTrandeFlow;
import com.taolili.domain.TaoliliWallet;
import com.taolili.mapper.TaoliliTrandeFlowMapper;
import com.taolili.mapper.TaoliliWalletMapper;
import com.taolili.service.TaoliliTrandeFlowService;
import com.taolili.service.TaoliliWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
* @author Administrator
* @description 针对表【taolili_wallet】的数据库操作Service实现
* @createDate 2023-03-25 13:29:50
*/
@Service
@Transactional
public class TaoliliWalletServiceImpl extends ServiceImpl<TaoliliWalletMapper, TaoliliWallet>
    implements TaoliliWalletService {

    @Autowired
    TaoliliWalletMapper taoliliWalletMapper;

    @Autowired
    TaoliliTrandeFlowMapper taoliliTrandeFlowMapper;


    @Override
    public TaoliliWallet queryTaoliliWallet(String userId) {
        LambdaQueryWrapper<TaoliliWallet> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TaoliliWallet::getUserId,userId);
        // TODO 不确定用户与钱包是不是一对一的关系
        return taoliliWalletMapper.selectList(wrapper).get(0);
    }

    @Override
    public synchronized void updateTaoliliWallet(String userId, String trandeCode, BigDecimal tradeAmount) {
        if (tradeAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("交易金额不能为复数");
        }
        // 先进行查询 查出钱包余额
        TaoliliWallet taoliliWallet = queryTaoliliWallet(userId);
        LambdaUpdateWrapper<TaoliliWallet> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(TaoliliWallet::getUserId,userId);
        BigDecimal walletBalance = taoliliWallet.getWalletBalance();
        // 判断是否大于0 是否为空
        if (walletBalance != null && walletBalance.compareTo(BigDecimal.ZERO) >= 0) {
            // 将交易记录插入交易流水表
            TaoliliTrandeFlow taoliliTrandeFlow = new TaoliliTrandeFlow();
            taoliliTrandeFlow.setWalletId(taoliliWallet.getId());
            taoliliTrandeFlow.setUserId(Long.valueOf(userId))
                    .setWalletId(taoliliWallet.getId())
                    .setTrandeCode(trandeCode)
                    .setTradeAmount(tradeAmount);

            if (TranceCodeConstant.CONSUME.equals(trandeCode)) {
                BigDecimal subtract = walletBalance.subtract(tradeAmount);
                if (subtract.compareTo(BigDecimal.ZERO) > 0) {
                    wrapper.set(TaoliliWallet::getWalletBalance,subtract);
                    taoliliTrandeFlow.setWalletBalance(subtract);
                } else {
                    throw new RuntimeException("余额不足");
                }
            }

            if (TranceCodeConstant.REFUND.equals(trandeCode)) {
                BigDecimal add = walletBalance.add(tradeAmount);
                wrapper.set(TaoliliWallet::getWalletBalance, add);
                taoliliTrandeFlow.setWalletBalance(add);
            }
            taoliliWalletMapper.update(null,wrapper);
            taoliliTrandeFlowMapper.insert(taoliliTrandeFlow);
        }else {
            throw new RuntimeException("余额不足");
        }
    }

}





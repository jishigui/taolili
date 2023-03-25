package com.taolili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taolili.domain.TaoliliWallet;

import java.math.BigDecimal;

/**
* @author Administrator
* @description 针对表【taolili_wallet】的数据库操作Service
* @createDate 2023-03-25 13:29:50
*/
public interface TaoliliWalletService extends IService<TaoliliWallet> {
    /**
     * 根据用户id查找钱包信息
     * @param userId 用户id
     * @return 钱包实体 ?不确定用户与钱包是不是一对一的关系?
     */
    TaoliliWallet queryTaoliliWallet(String userId);

    /**
     * 用户退款或消费
     * @param userId 用户id
     * @param trandeCode 操作码
     * @param tradeAmount 交易金额
     */
    void updateTaoliliWallet(String userId, String trandeCode, BigDecimal tradeAmount);
}

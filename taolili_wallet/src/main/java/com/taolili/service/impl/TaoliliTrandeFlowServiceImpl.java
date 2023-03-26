package com.taolili.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taolili.domain.TaoliliTrandeFlow;
import com.taolili.service.TaoliliTrandeFlowService;
import com.taolili.mapper.TaoliliTrandeFlowMapper;
import org.springframework.stereotype.Service;
import sun.invoke.util.Wrapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【taolili_trande_flow(交易流水表)】的数据库操作Service实现
* @createDate 2023-03-25 13:29:19
*/
@Service
public class TaoliliTrandeFlowServiceImpl extends ServiceImpl<TaoliliTrandeFlowMapper, TaoliliTrandeFlow>
    implements TaoliliTrandeFlowService {

    public TaoliliTrandeFlowServiceImpl(TaoliliTrandeFlowMapper taoliliTrandeFlowMapper) {
        this.taoliliTrandeFlowMapper = taoliliTrandeFlowMapper;
    }

    TaoliliTrandeFlowMapper taoliliTrandeFlowMapper;


    @Override
    public List<TaoliliTrandeFlow> queryFlow(String userId) {
        LambdaQueryWrapper<TaoliliTrandeFlow> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TaoliliTrandeFlow::getUserId, userId);
        return taoliliTrandeFlowMapper.selectList(wrapper);
    }
}





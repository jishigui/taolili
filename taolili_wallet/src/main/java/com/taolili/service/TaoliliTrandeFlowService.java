package com.taolili.service;

import com.taolili.domain.TaoliliTrandeFlow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【taolili_trande_flow(交易流水表)】的数据库操作Service
* @createDate 2023-03-25 13:29:19
*/
public interface TaoliliTrandeFlowService extends IService<TaoliliTrandeFlow> {

    /**
     * 查询
     * @param userId
     * @return 交易流水表
     */
    List<TaoliliTrandeFlow> queryFlow(String userId);
}

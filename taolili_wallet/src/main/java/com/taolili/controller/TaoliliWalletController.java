package com.taolili.controller;

import com.taolili.domain.TaoliliTrandeFlow;
import com.taolili.service.TaoliliTrandeFlowService;
import com.taolili.service.TaoliliWalletService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/taolili")
public class TaoliliWalletController {

    private TaoliliWalletService taoliliWalletService;

    private TaoliliTrandeFlowService taoliliTrandeFlowService;


    public TaoliliWalletController(TaoliliWalletService taoliliWalletService, TaoliliTrandeFlowService taoliliTrandeFlowService) {
        this.taoliliWalletService = taoliliWalletService;
        this.taoliliTrandeFlowService = taoliliTrandeFlowService;
    }

    /**
     * 查询钱包余额
     * @param userId
     * @return
     */
    @GetMapping("/query/balance")
    public BigDecimal queryBalance(@RequestParam("userId") String userId) {
        return taoliliWalletService.queryTaoliliWallet(userId).getWalletBalance();
    }

    /**
     * 用户消费
     * @param userId
     * @param trandeCode
     * @param tradeAmount
     */
    @PostMapping("/update")
    public void updateBalance(@RequestParam("userId") String userId,@RequestParam("trandeCode") String trandeCode,@RequestParam("tradeAmount") BigDecimal tradeAmount) {
        taoliliWalletService.updateTaoliliWallet(userId, trandeCode, tradeAmount);
    }

    /**
     * 查询用户金额变动
     * @param userId
     * @return
     */
    @GetMapping("/query/flow")
    List<TaoliliTrandeFlow> queryFlow(@RequestParam("userId") String userId) {
        return taoliliTrandeFlowService.queryFlow(userId);
    }
}

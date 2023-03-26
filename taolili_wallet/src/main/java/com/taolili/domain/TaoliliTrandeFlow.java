package com.taolili.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * 交易流水表
 * @TableName taolili_trande_flow
 */
@TableName(value ="taolili_trande_flow")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaoliliTrandeFlow implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 钱包id
     */
    private Long walletId;

    /**
     * 0消费 1退款
     */
    private String trandeCode;

    /**
     * 交易金额
     */
    private BigDecimal tradeAmount;

    /**
     * 钱包余额
     */
    private BigDecimal walletBalance;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
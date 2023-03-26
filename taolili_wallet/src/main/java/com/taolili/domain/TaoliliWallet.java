package com.taolili.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName taolili_wallet
 */
@TableName(value ="taolili_wallet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaoliliWallet implements Serializable {
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 余额
     */
    private BigDecimal walletBalance;

    /**
     * 版本号
     */
    @Version
    private Long version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
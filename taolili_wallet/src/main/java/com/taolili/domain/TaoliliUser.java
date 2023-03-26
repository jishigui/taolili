package com.taolili.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName taolili_user
 */
@TableName(value ="taolili_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaoliliUser implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 0代表女 1代表男 2代表性别未确定
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 版本号
     */
    @Version
    private Long version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
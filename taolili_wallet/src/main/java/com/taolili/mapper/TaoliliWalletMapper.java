package com.taolili.mapper;

import com.taolili.domain.TaoliliWallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
* @author Administrator
* @description 针对表【taolili_wallet】的数据库操作Mapper
* @createDate 2023-03-25 13:36:38
* @Entity com.taolili.domain.TaoliliWallet
*/
@Mapper
public interface TaoliliWalletMapper extends BaseMapper<TaoliliWallet> {

    @Select("SELECT id,user_id,create_time,update_time,wallet_balance,version FROM taolili_wallet WHERE user_id = #{userId} FOR UPDATE")
    TaoliliWallet queryTaoliliWallet(String userId);

}





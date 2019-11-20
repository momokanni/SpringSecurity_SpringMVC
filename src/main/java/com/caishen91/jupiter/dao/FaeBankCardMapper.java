package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeBankCard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FaeBankCardMapper {

    @Select("select * from fae_bank_card where investorId = #{investorId}")
    List<FaeBankCard> getFaeBankCardByInvestorId(@Param("investorId") int investorId);
}

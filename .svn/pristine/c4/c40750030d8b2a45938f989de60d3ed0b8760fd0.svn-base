package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeInvestorAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FaeInvestorAccountMapper {

    @Select("select * from fae_investor_account where investorId = #{investorId}")
    FaeInvestorAccount getFaeInvestorAccountByInvestorId(@Param("investorId") int investorId);
}

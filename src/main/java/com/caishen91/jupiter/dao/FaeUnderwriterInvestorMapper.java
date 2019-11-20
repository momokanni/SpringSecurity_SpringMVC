package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeUnderwriterInvestor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FaeUnderwriterInvestorMapper {
    @Select("select * from fae_underwriter_investor where investorId = #{investorId}")
    List<FaeUnderwriterInvestor> getFaeUnderwriterInvestorByInvestorId(@Param("investorId") int investorId);
}

package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeInvestor;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface FaeInvestorMapper {

    @Insert("insert into fae_investor" +
            "                       (" +
            "                           type, realName, idCardNo, mobile, userSource, referrer, companyName, " +
            "                           creditCode, businessLicense, legalPersonName, contacts, contactsTel, createTime" +
            "                       ) " +
            "                   values" +
            "                       (" +
            "                           #{type}, #{realName}, #{idCardNo}, #{mobile}, #{userSource}, #{referrer}, #{companyName}, " +
            "                           #{creditCode}, #{businessLicense}, #{legalPersonName}, #{contacts}, #{contactsTel}, #{createTime}" +
            "                       )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addFaeInvestor(FaeInvestor faeInvestor);

    @Select("select * from fae_investor where id = #{investorId}")
    FaeInvestor getFaeInvestorById(@Param("investorId") int investorId);

    @SelectProvider(type = FaeInvestorProvider.class, method = "queryFaeInvestorCountByParam")
    int queryFaeInvestorCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeInvestorProvider.class, method = "queryFaeInvestorListByParam")
    List<FaeInvestor> queryFaeInvestorListByParam(Map<String, Object> paramMap);
}

package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeInvestRecord;
import com.caishen91.jupiter.vo.FaeInvestRecordVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeInvestRecordMapper {


    @SelectProvider(type = FaeInvestRecordProvider.class,method = "queryFaeInvestRecordCountByParam")
    int queryFaeInvestRecordCountByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeInvestRecordProvider.class,method = "queryFaeInvestRecordByParam")
    List<FaeInvestRecordVo> queryFaeInvestRecordByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeInvestRecordProvider.class,method = "queryFaeInvestRecordCountMapByParam")
    Map queryFaeInvestRecordCountMapByParam(Map<String,Object> paramMap);

    @Select("select sum(investAmount) from fae_invest_record")
    BigDecimal getTotalInvestAmount();

    @Select("select * from fae_invest_record where investorId = #{investorId}")
    List<FaeInvestRecord> getFaeInvestRecordByInvestorId(@Param("investorId") int investorId);
}

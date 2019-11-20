package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeInvestorRepayPhase;
import com.caishen91.jupiter.vo.FaeInvestorRepayPhaseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeRepayPhaseMapper {
    @SelectProvider(type = FaeRepayPhaseProvider.class,method = "queryFaeRepayPhaseCountByParam")
    int queryFaeRepayPhaseCountByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeRepayPhaseProvider.class,method = "queryFaeRepayPhaseByParam")
    List<FaeInvestorRepayPhaseVo> queryFaeRepayPhaseByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeRepayPhaseProvider.class,method = "queryFaeRepayPhaseCountMapByParam")
    Map queryFaeRepayPhaseCountMapByParam(Map<String,Object> paramMap);


    @Select("select * from fae_investor_repay_phase where investRecordId = #{recordId}")
    List<FaeInvestorRepayPhase> getRepayPhaseByInvestRecordId( @Param("recordId") int id);
}

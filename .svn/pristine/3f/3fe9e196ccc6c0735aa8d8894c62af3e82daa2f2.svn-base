package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeInvestRecord;
import com.caishen91.jupiter.vo.FaeInvestRecordVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeInvestRecordService {

    int queryFaeInvestRecordCountByParam(Map<String,Object> paramMap);

    List<FaeInvestRecordVo> queryFaeInvestRecordByParam(Map<String,Object> paramMap);

    Map queryFaeInvestRecordCountMapByParam(Map<String,Object> paramMap);

    BigDecimal getTotalInvestAmount();

    List<FaeInvestRecord> getFaeInvestRecordByInvestorId(int investorId);
}

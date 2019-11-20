package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeInvestRecordMapper;
import com.caishen91.jupiter.model.FaeInvestRecord;
import com.caishen91.jupiter.service.IFaeInvestRecordService;
import com.caishen91.jupiter.vo.FaeInvestRecordVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 37
 * Description:
 */
@Service
public class FaeInvestRecordServiceImpl extends BaseService implements IFaeInvestRecordService {
    @Override
    public int queryFaeInvestRecordCountByParam(Map<String, Object> paramMap) {
        FaeInvestRecordMapper investRecordMapper = writableSQLSession.getMapper(FaeInvestRecordMapper.class);
        return investRecordMapper.queryFaeInvestRecordCountByParam(paramMap);
    }

    @Override
    public List<FaeInvestRecordVo> queryFaeInvestRecordByParam(Map<String, Object> paramMap) {
        FaeInvestRecordMapper investRecordMapper = writableSQLSession.getMapper(FaeInvestRecordMapper.class);
        return investRecordMapper.queryFaeInvestRecordByParam(paramMap);
    }

    @Override
    public Map queryFaeInvestRecordCountMapByParam(Map<String, Object> paramMap) {
        FaeInvestRecordMapper investRecordMapper = writableSQLSession.getMapper(FaeInvestRecordMapper.class);
        return investRecordMapper.queryFaeInvestRecordCountMapByParam(paramMap);
    }

    @Override
    public BigDecimal getTotalInvestAmount() {
        FaeInvestRecordMapper investRecordMapper = writableSQLSession.getMapper(FaeInvestRecordMapper.class);
        return investRecordMapper.getTotalInvestAmount();
    }

    @Override
    public List<FaeInvestRecord> getFaeInvestRecordByInvestorId(int investorId) {
        FaeInvestRecordMapper investRecordMapper = writableSQLSession.getMapper(FaeInvestRecordMapper.class);
        return investRecordMapper.getFaeInvestRecordByInvestorId(investorId);
    }
}

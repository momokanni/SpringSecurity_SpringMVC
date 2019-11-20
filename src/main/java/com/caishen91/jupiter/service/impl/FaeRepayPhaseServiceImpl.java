package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeRepayPhaseMapper;
import com.caishen91.jupiter.model.FaeInvestorRepayPhase;
import com.caishen91.jupiter.service.IFaeRepayPhaseService;
import com.caishen91.jupiter.vo.FaeInvestorRepayPhaseVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/25/19 14 29
 * Description:
 */
@Service
public class FaeRepayPhaseServiceImpl extends BaseService implements IFaeRepayPhaseService {

    @Override
    public int queryFaeRepayPhaseCountByParam(Map<String, Object> paramMap) {
        FaeRepayPhaseMapper repayPhaseMapper = writableSQLSession.getMapper(FaeRepayPhaseMapper.class);
        return repayPhaseMapper.queryFaeRepayPhaseCountByParam(paramMap);
    }

    @Override
    public List<FaeInvestorRepayPhaseVo> queryFaeRepayPhaseByParam(Map<String, Object> paramMap) {
        FaeRepayPhaseMapper repayPhaseMapper = writableSQLSession.getMapper(FaeRepayPhaseMapper.class);
        return repayPhaseMapper.queryFaeRepayPhaseByParam(paramMap);
    }

    @Override
    public Map queryFaeRepayPhaseCountMapByParam(Map<String, Object> paramMap) {
        FaeRepayPhaseMapper repayPhaseMapper = writableSQLSession.getMapper(FaeRepayPhaseMapper.class);
        return repayPhaseMapper.queryFaeRepayPhaseCountMapByParam(paramMap);
    }

    @Override
    public List<FaeInvestorRepayPhase> getRepayPhaseByInvestRecordId(int id) {
        FaeRepayPhaseMapper repayPhaseMapper = writableSQLSession.getMapper(FaeRepayPhaseMapper.class);
        return repayPhaseMapper.getRepayPhaseByInvestRecordId(id);
    }
}

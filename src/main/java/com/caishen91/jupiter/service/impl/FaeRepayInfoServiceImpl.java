package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeRepayInfoMapper;
import com.caishen91.jupiter.model.FaeRepayInfo;
import com.caishen91.jupiter.service.IFaeRepayInfoService;
import com.caishen91.jupiter.vo.FaeRepayInfoVo;
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
public class FaeRepayInfoServiceImpl extends BaseService implements IFaeRepayInfoService {

    @Override
    public int queryFaeRepayInfoCountByParam(Map<String, Object> paramMap) {
        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);
        return repayInfoMapper.queryFaeRepayInfoCountByParam(paramMap);
    }

    @Override
    public Map queryFaeRepayInfoCountMapByParam(Map<String, Object> paramMap) {
        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);
        return repayInfoMapper.queryFaeRepayInfoCountMapByParam(paramMap);
    }

    @Override
    public List<FaeRepayInfoVo> queryFaeRepayInfoByParam(Map<String, Object> paramMap) {
        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);
        return repayInfoMapper.queryFaeRepayInfoByParam(paramMap);
    }

    @Override
    public FaeRepayInfo getRepayInfoById(int id) {
        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);
        return repayInfoMapper.getRepayInfoById(id);
    }

    @Override
    public boolean updateRepayInfoStatus(FaeRepayInfo repayInfoById) {

        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);

        try {
            repayInfoMapper.updateRepayInfoStatus(repayInfoById);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BigDecimal getNotRepayPrincipal() {

        FaeRepayInfoMapper repayInfoMapper = writableSQLSession.getMapper(FaeRepayInfoMapper.class);
        return repayInfoMapper.getNotRepayPrincipal();
    }
}

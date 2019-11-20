package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeUnderwriterInvestorMapper;
import com.caishen91.jupiter.model.FaeUnderwriterInvestor;
import com.caishen91.jupiter.service.IFaeUnderwriterInvestorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaeUnderwriterInvestorServiceImpl extends BaseService implements IFaeUnderwriterInvestorService {

    @Override
    public List<FaeUnderwriterInvestor> getFaeUnderwriterInvestorByInvestorId(int investorId) {
        FaeUnderwriterInvestorMapper faeUnderwriterInvestorMapper = writableSQLSession.getMapper(FaeUnderwriterInvestorMapper.class);
        return faeUnderwriterInvestorMapper.getFaeUnderwriterInvestorByInvestorId(investorId);
    }

}

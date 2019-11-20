package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeInvestorAccountMapper;
import com.caishen91.jupiter.model.FaeInvestorAccount;
import com.caishen91.jupiter.service.IFaeInvestorAccountService;
import org.springframework.stereotype.Service;

@Service
public class FaeInvestorAccountServiceImpl extends BaseService implements IFaeInvestorAccountService {

    @Override
    public FaeInvestorAccount getFaeInvestorAccountByInvestorId(int investorId) {
        FaeInvestorAccountMapper faeInvestorAccountMapper = writableSQLSession.getMapper(FaeInvestorAccountMapper.class);
        return faeInvestorAccountMapper.getFaeInvestorAccountByInvestorId(investorId);
    }
}

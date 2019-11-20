package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeBankCardMapper;
import com.caishen91.jupiter.model.FaeBankCard;
import com.caishen91.jupiter.service.IFaeBankCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaeBankCardServiceImpl extends BaseService implements IFaeBankCardService {

    @Override
    public List<FaeBankCard> getFaeBankCardByInvestorId(int investorId) {
        FaeBankCardMapper faeBankCardMapper = writableSQLSession.getMapper(FaeBankCardMapper.class);
        return faeBankCardMapper.getFaeBankCardByInvestorId(investorId);
    }
}

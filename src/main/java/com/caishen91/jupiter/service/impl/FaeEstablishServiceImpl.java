package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeEstablishMapper;
import com.caishen91.jupiter.model.FaeEstablishInfo;
import com.caishen91.jupiter.service.IFaeEstablishService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/25/19 10 30
 * Description:
 */
@Service
public class FaeEstablishServiceImpl extends BaseService implements IFaeEstablishService {

    @Override
    public int queryFaeEstablishInfoCountByParam(Map<String, Object> paramMap) {
        FaeEstablishMapper establishMapper = writableSQLSession.getMapper(FaeEstablishMapper.class);
        return establishMapper.queryFaeEstablishInfoCountByParam(paramMap);
    }

    @Override
    public List<FaeEstablishInfo> queryFaeEstablishInfoByParam(Map<String, Object> paramMap) {
        FaeEstablishMapper establishMapper = writableSQLSession.getMapper(FaeEstablishMapper.class);
        return establishMapper.queryFaeEstablishInfoByParam(paramMap);
    }
}



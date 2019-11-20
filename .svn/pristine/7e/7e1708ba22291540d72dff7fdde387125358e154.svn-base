package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeProductMapper;
import com.caishen91.jupiter.model.FaeProduct;
import com.caishen91.jupiter.service.IFaeProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 37
 * Description:
 */
@Service
public class FaeProductServiceImpl extends BaseService implements IFaeProductService {

    @Override
    public boolean saveProduct(FaeProduct product) {
        FaeProductMapper faeProductMapper = writableSQLSession.getMapper(FaeProductMapper.class);

        try {
            faeProductMapper.saveProduct(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int queryCountFaeProductByParam(Map<String, Object> queryMap) {
        FaeProductMapper faeProductMapper = writableSQLSession.getMapper(FaeProductMapper.class);
        return faeProductMapper.queryCountFaeProductByParam(queryMap);
    }

    @Override
    public List<Map<String,Object>> queryFaeProductMapByParam(Map<String, Object> queryMap) {
        FaeProductMapper faeProductMapper = writableSQLSession.getMapper(FaeProductMapper.class);
        return faeProductMapper.queryFaeProductMapByParam(queryMap);
    }

    @Override
    public List<FaeProduct> queryFaeProductByParam(Map<String, Object> queryMap) {
        FaeProductMapper faeProductMapper = writableSQLSession.getMapper(FaeProductMapper.class);
        return faeProductMapper.queryFaeProductByParam(queryMap);
    }

    @Override
    public FaeProduct getFaeProductById(int id) {
        FaeProductMapper faeProductMapper = writableSQLSession.getMapper(FaeProductMapper.class);
        return faeProductMapper.getFaeProductById(id);
    }
}

package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeEstablishInfo;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeEstablishMapper {

    @SelectProvider(type = FaeEstablishProvider.class,method = "queryFaeEstablishInfoCountByParam")
    int queryFaeEstablishInfoCountByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeEstablishProvider.class,method = "queryFaeEstablishInfoByParam")
    List<FaeEstablishInfo> queryFaeEstablishInfoByParam(Map<String,Object> paramMap);

    /*@SelectProvider(type = FaeRepayInfoProvider.class,method = "queryFaeRepayInfoCountByParam")
    int queryFaeRepayInfoCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeRepayInfoProvider.class,method = "queryFaeRepayInfoByParam")
    List<FaeRepayInfoVo> queryFaeRepayInfoByParam(Map<String, Object> paramMap);*/

}

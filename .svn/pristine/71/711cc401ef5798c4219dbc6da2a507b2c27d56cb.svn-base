package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeRepayInfo;
import com.caishen91.jupiter.vo.FaeRepayInfoVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeRepayInfoService {


    int queryFaeRepayInfoCountByParam(Map<String,Object> paramMap);

    List<FaeRepayInfoVo> queryFaeRepayInfoByParam(Map<String,Object> paramMap);

    FaeRepayInfo getRepayInfoById(int id);

    boolean updateRepayInfoStatus(FaeRepayInfo repayInfoById);

    BigDecimal getNotRepayPrincipal();

    Map queryFaeRepayInfoCountMapByParam(Map<String,Object> paramMap);
}

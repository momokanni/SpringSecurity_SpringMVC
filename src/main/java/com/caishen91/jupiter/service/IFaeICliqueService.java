package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeClique;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeICliqueService {
    List<FaeClique> getFaeCliqueByName(String cliqueName);

    void addFaeClique(FaeClique faeClique);

    int queryFaeCliqueCountByParam(Map<String, Object> paramMap);

    List<FaeClique> queryFaeCliqueListByParam(Map<String, Object> paramMap);

    FaeClique getFaeCliqueById(int cliqueId);

    FaeClique getFaeCliqueByCreditCode(String creditCode);

    void setSysUserId(int sysUserId);
}

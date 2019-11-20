package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeEntrusted;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeEntrustedService {
    List<FaeEntrusted> getFaeEntrustedBySgt(String keys);

    void addFaeEntrusted(FaeEntrusted faeEntrusted);

    int queryFaeEntrustedCountByParam(Map<String, Object> paramMap);

    List<FaeEntrusted> queryFaeEntrustedListByParam(Map<String, Object> paramMap);

    FaeEntrusted getFaeEntrustedById(int entrustedId);

    FaeEntrusted getFaeEntrustedByCreditCode(String creditCode);

    void setSysUserId(int sysUserId);
}

package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeUnderwriter;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeUnderwriterService {
    List<FaeUnderwriter> getFaeUnderwriterBySgt(String keys);

    void addFaeUnderwriter(FaeUnderwriter faeUnderwriter);

    int queryFaeUnderwriterCountByParam(Map<String, Object> paramMap);

    List<FaeUnderwriter> queryFaeUnderwriterListByParam(Map<String, Object> paramMap);

    FaeUnderwriter getFaeUnderwriterById(int underwriterId);

    List<FaeUnderwriter> getFaeUnderwriterByIds(List<Integer> underwriterIds);

    FaeUnderwriter getFaeUnderwriterByCreditCode(String creditCode);

    void setSysUserId(int sysUserId);
}

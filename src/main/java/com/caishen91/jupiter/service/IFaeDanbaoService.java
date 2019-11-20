package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeDanbao;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeDanbaoService {
    List<FaeDanbao> getFaeDanbaoBySgt(String keys);

    void addFaeDanbao(FaeDanbao faeDanbao);

    int queryFaeanbaoCountByParam(Map<String, Object> paramMap);

    List<FaeDanbao> queryFaeDanbaoListByParam(Map<String, Object> paramMap);

    FaeDanbao getFaeDanbaoById(int danbaoId);

    FaeDanbao getFaeDanbaoByCreditCode(String creditCode);

    void setSysUserId(int sysUserId);
}

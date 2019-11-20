package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeDanbaoMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeDanbao;
import com.caishen91.jupiter.service.IFaeDanbaoService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 28
 * Description:
 */
@Service
public class FaeDanbaoServiceImpl extends BaseService implements IFaeDanbaoService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public List<FaeDanbao> getFaeDanbaoBySgt(String keys) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        return faeDanbaoMapper.getFaeDanbaoBySgt(keys);
    }

    @Override
    public void addFaeDanbao(FaeDanbao faeDanbao) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        faeDanbaoMapper.addFaeDanbao(faeDanbao);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeDanbao));
    }

    @Override
    public int queryFaeanbaoCountByParam(Map<String, Object> paramMap) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        return faeDanbaoMapper.queryFaeanbaoCountByParam(paramMap);
    }

    @Override
    public List<FaeDanbao> queryFaeDanbaoListByParam(Map<String, Object> paramMap) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        return faeDanbaoMapper.queryFaeDanbaoListByParam(paramMap);
    }

    @Override
    public FaeDanbao getFaeDanbaoById(int danbaoId) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        return faeDanbaoMapper.getFaeDanbaoById(danbaoId);
    }

    @Override
    public FaeDanbao getFaeDanbaoByCreditCode(String creditCode) {
        FaeDanbaoMapper faeDanbaoMapper = writableSQLSession.getMapper(FaeDanbaoMapper.class);
        return faeDanbaoMapper.getFaeDanbaoByCreditCode(creditCode);
    }


}

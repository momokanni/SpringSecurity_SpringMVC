package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.ArticleTypeMapper;
import com.caishen91.jupiter.dao.NoticeMapper;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.service.INoticeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl extends BaseService implements INoticeService {

    @Override
    public int getTotalNoticeCountByParams(Map queryMap) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.getTotalNoticeCountByParams(queryMap);

    }

    @Override
    public List<Notice> getNoticeByParams(Map queryMap) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.getNoticeByParams(queryMap);
    }

    @Override
    public Notice getNoticeById(int id) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.getNoticeById(id);
    }

    @Override
    public boolean setStNoticeatus(Notice notice) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.setStNoticeatus(notice);
    }

    @Override
    public boolean addNotice(Notice notice) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.addNotice(notice);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public void update5MinToBeReleasedNotice(int status, Date date, int istatus, String endTime) {
        NoticeMapper noticeMapper = writableSQLSession.getMapper(NoticeMapper.class);
         noticeMapper.update5MinToBeReleasedNotice(status,date,istatus,endTime);
    }
}

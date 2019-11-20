package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.Notice;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface INoticeService {
    int getTotalNoticeCountByParams(Map queryMap);

    List<Notice> getNoticeByParams(Map queryMap);

    Notice getNoticeById(int id);

    boolean setStNoticeatus(Notice notice);

    boolean addNotice(Notice notice);

    boolean updateNotice(Notice notice);

    void update5MinToBeReleasedNotice(int id, Date date, int id1, String endTime);
}

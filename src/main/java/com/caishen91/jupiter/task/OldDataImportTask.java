package com.caishen91.jupiter.task;

import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleShareService;
import com.caishen91.jupiter.service.INoticeService;
import com.caishen91.jupiter.util.DateUtil;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OldDataImportTask{

    private static final Logger logger = (Logger) Logger.getLogger(OldDataImportTask.class);

    @Autowired
    private IArticleService articleService;

	@Autowired
	private INoticeService noticeService;
	
	@Autowired
	private IArticleShareService articleShareService;

    /**
     * 	文章定时发布
     */
	/*
	 * @Scheduled(cron = "0 0/5 * * * ?") public void handleExcelHandle() { //
	 * 获取五分钟内需要发布的所有文章id Long currentTime = System.currentTimeMillis(); String
	 * startTime = DateUtil.formatDateByLong(currentTime, "yyyy-MM-dd HH:mm:ss");
	 * Date date = new Date(currentTime); currentTime += 5 * 1000 * 60; String
	 * endTime = DateUtil.formatDateByLong(currentTime, "yyyy-MM-dd HH:mm:ss");
	 * articleService.update5MinToBeReleased(Article.ArticleStatus.hasBeenReleased.
	 * getId(),new Date(),Article.ArticleStatus.toBeReleased.getId(),endTime); }
	 */
    
    /**
     * 	文章定时推送
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void shareArticle() {
        Long currentTime = System.currentTimeMillis();
        // currentTime += 5 * 1000 * 60;
        String endTime = DateUtil.formatDateByLong(currentTime, "yyyy-MM-dd HH:mm:ss");
        articleShareService.update5MinToBeShare(endTime);
    }


	/**
	 * 	公告定时发布
	 */
	@Scheduled(cron = "0 0/5 * * * ?")
	public void reaalseNoticeHandle() {
		Long currentTime = System.currentTimeMillis();
		String startTime = DateUtil.formatDateByLong(currentTime, "yyyy-MM-dd HH:mm:ss");
		Date date = new Date(currentTime);
		currentTime += 5 * 1000 * 60;
		String endTime = DateUtil.formatDateByLong(currentTime, "yyyy-MM-dd HH:mm:ss");
		noticeService.update5MinToBeReleasedNotice(Notice.NoticeStatus.hasBeenReleased.getId(),new Date(),Notice.NoticeStatus.toBeReleased.getId(),endTime);
	}
}

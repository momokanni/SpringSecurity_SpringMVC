package com.caishen91.jupiter.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.service.IAccountService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.INoticeService;
import com.caishen91.jupiter.util.IDEncryptor;

/**
 * @Auther: jgn
 * @Date: 3/26/19 10 13
 * Description:
 */

@Controller
@RequestMapping("/manager/console")
public class ManagerConsoleController {

    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private IAccountService accountService;


    @Autowired
    private IBlogManagerService blogManagerService;

    @Autowired
    private INoticeService noticeService;


    @RequestMapping("/outline")
    public String toOutline(){



        int articleYesterdayCount=accountService.getArticleCountYesterday();
        request.setAttribute("articleYesterdayCount",articleYesterdayCount);
        int articleCount=accountService.getArticleCount();
        request.setAttribute("articleCount",articleCount);

        int AccountYesterdayCount=accountService.getAccountCountYesterday();
        request.setAttribute("AccountYesterdayCount",AccountYesterdayCount);
        int AccountCount=accountService.getAccountCount();
        request.setAttribute("AccountCount",AccountCount);
        //商户端公告
        int[] noticePlatform = {Notice.NoticeType.insidePlatform.getId(),Notice.NoticeType.whole.getId()};
        Notice notice = blogManagerService.getNoticeByType(noticePlatform,Notice.NoticeStatus.hasBeenReleased.getId());
        request.setAttribute("notice",notice);
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/console/outline";
    }

    @RequestMapping("/waitRepay")
    public String waitRepay(){
        return "../managers/console/waitRepay";
    }



    /**
     * @Auther: gk
     * Description:跳转公告详情页
     */
    @RequestMapping("/noticeDetail")
    public String  noticeDetail(HttpServletRequest request, HttpServletResponse response) {
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        String idStr=request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        Notice notice=noticeService.getNoticeById(id);
        request.setAttribute("notice",notice);
        return "../managers/notice/noticeDetail";
    }



    /**
     * @Auther: gk
     * Description:跳转公告列表页
     */
    @GetMapping("/noticeList")
    public String noticList(HttpServletRequest request,HttpServletResponse response) {
    	
        List<Notice> notices=blogManagerService.getBlogNoticeByType(Notice.NoticeType.merchant.getId(),Notice.NoticeStatus.hasBeenReleased.getId());
        request.setAttribute("notices",notices);
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/notice/indexNoticeList";
    }

}

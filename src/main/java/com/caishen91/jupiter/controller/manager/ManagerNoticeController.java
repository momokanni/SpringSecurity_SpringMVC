package com.caishen91.jupiter.controller.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.service.INoticeService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

/**
 * @Auther: gk
 * @Date: 4/19/19 9 30
 * Description:
 */
@Controller
@RequestMapping("/manager/notice")
public class ManagerNoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping("/noticeList")
    public String noticeList(HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/notice/noticeList";
    }


    @GetMapping("/editNotice")
    public String editNotice(HttpServletRequest request, HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        String idStr = request.getParameter("id");
        if(StringUtil.isNotEmpty(idStr)){
            int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
            Notice notice = noticeService.getNoticeById(id);
            request.setAttribute("notice",notice);
        }
        return "../managers/notice/editNotice";
    }


    @GetMapping("/showNoticeInfo")
    public String showNoticeInfo(HttpServletRequest request, HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        String idStr = request.getParameter("id");
        if(StringUtil.isNotEmpty(idStr)){
            int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
            Notice notice = noticeService.getNoticeById(id);
            request.setAttribute("notice",notice);
        }
        return "../managers/notice/showNoticeInfo";
    }


    @GetMapping("/queryNoticeList")
    @ResponseBody
    public Map<String,Object> queryNoticeList(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }
        int page = 1;
        try {
            page = Integer.valueOf(request.getParameter("pageNo"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        int pageCount = 10;

        Map queryMap = new HashMap();

        String title = request.getParameter("title");
        if (StringUtil.isNotEmpty(title)) {
            queryMap.put("title", title);
        }

        queryMap.put("offset", (page -1) * pageCount);
        queryMap.put("pageSize", pageCount);

        String[] statuses = request.getParameterValues("status");
        if (statuses != null && statuses.length > 0) {
            List<Integer> sts = new ArrayList();
            for(String s : statuses) {
                sts.add(Integer.valueOf(s));
            }
            queryMap.put("statuses", sts);
        }

        int total = noticeService.getTotalNoticeCountByParams(queryMap);

        List<Notice> notices = noticeService.getNoticeByParams(queryMap);

        List<Map> resultMap = new ArrayList();

        for(int i = 0; i < notices.size(); i++) {
            Notice notice = notices.get(i);


            String encId = IDEncryptor.getInstance().encryptWithoutException(notice.getId());

            Map m = new HashMap();

            m.put("id", notice.getId());

            m.put("title", notice.getTitle());

            m.put("typeName", Notice.NoticeType.getNoticeType(notice.getType()).getDesc());

            m.put("releaseTime", DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));

            m.put("status",Notice.NoticeStatus.getNoticeStatus(notice.getStatus()).getDesc());

            List<Action> actions = new ArrayList<Action>();
            m.put("opList", actions);


            if(notice.getStatus()==Notice.NoticeStatus.toBeReleased.getId()||notice.getStatus()==Notice.NoticeStatus.hasBeenReleased.getId()){

                Action disableAction = ActionFactory.build("撤回",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/notice/setNoticeStatus?id=" + encId + "&status=3",
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(disableAction);
                Action detailAction = ActionFactory.build("查看",
                        "/manager/notice/showNoticeInfo?id=" + encId,
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_LINK ,
                        "",
                        "" ,
                        "");
                actions.add(detailAction);
            }else{
                Action enableAction = ActionFactory.build("发布",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/notice/setNoticeStatus?id=" + encId + "&status=2",
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(enableAction);
                Action detailAction = ActionFactory.build("编辑",
                        "/manager/notice/editNotice?id=" + encId,
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_LINK ,
                        "",
                        "" ,
                        "");
                actions.add(detailAction);
            }


            resultMap.add(m);
        }

        Map data = new HashMap();
        data.put("totalRows", total);
        data.put("nav", "");
        data.put("content", resultMap);
        retMap.put("data", data);

        return retMap;

    }



    @RequestMapping("/setNoticeStatus")
    @ResponseBody
    public Map<String,Object> setNoticeStatus(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");

        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);

        Notice notice = noticeService.getNoticeById(id);
        if(notice == null){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "没有该公告");
            return  retMap;
        }
        String statusStr = request.getParameter("status");
        int status = Integer.valueOf(statusStr);
        notice.setStatus(status);

        boolean b = false;

        try {
            b = noticeService.setStNoticeatus(notice);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }



    @RequestMapping("/addNotice")
    @ResponseBody
    public Map<String,Object> addNotice(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        Notice notice = new Notice();
        notice.setCreateTime(new Date());
        String title = request.getParameter("title");
        if (StringUtil.isEmpty(title)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "公告标题不可为空");
            return retMap;
        }
        notice.setTitle(title);

        String content = request.getParameter("content");
        if (StringUtil.isEmpty(content)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "内容不能为空");
            return retMap;
        }
        notice.setContent(content);

        String typeStr = request.getParameter("type");
        if (StringUtil.isEmpty(typeStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "公告类型不能为空");
            return retMap;
        }
        int type = Integer.valueOf(typeStr);
        notice.setType(type);

        String validTypeStr=request.getParameter("validType");
        if (StringUtil.isEmpty(validTypeStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "请设置发布类型");
            return retMap;
        }
        int validType = Integer.valueOf(validTypeStr);
        notice.setValidType(validType);

        if(validType==0){

            notice.setStatus(Notice.NoticeStatus.hasBeenReleased.getId());
            notice.setReleaseTime(new Date());

        }else if(validType==1){
            String timeStr=request.getParameter("time");
            if (StringUtil.isEmpty(timeStr)) {
                retMap.put(Config.RET, 0);
                retMap.put(Config.ERR_MSG, "请选择待发布时间");
                return retMap;
            }
            Date time=DateUtil.parseDate(timeStr,"yyyy-MM-dd HH:mm:ss");

            notice.setStatus(Notice.NoticeStatus.toBeReleased.getId());
            notice.setReleaseTime(time);

        }
        boolean b = false;

        try {
            b =noticeService.addNotice(notice);

        }catch (Exception e){
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }


    @RequestMapping("/updateNotice")
    @ResponseBody
    public Map<String,Object> updateNotice(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        Notice notice = noticeService.getNoticeById(id);

        String title = request.getParameter("title");
        if (StringUtil.isEmpty(title)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "公告标题不可为空");
            return retMap;
        }
        notice.setTitle(title);

        String content = request.getParameter("content");
        if (StringUtil.isEmpty(content)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "内容不能为空");
            return retMap;
        }
        notice.setContent(content);

        String typeStr = request.getParameter("type");
        if (StringUtil.isEmpty(typeStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "公告类型不能为空");
            return retMap;
        }
        int type = Integer.valueOf(typeStr);
        notice.setType(type);

        String validTypeStr=request.getParameter("validType");
        if (StringUtil.isEmpty(validTypeStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "请设置发布类型");
            return retMap;
        }
        int validType = Integer.valueOf(validTypeStr);
        notice.setValidType(validType);

        if(validType==0){

            notice.setStatus(Notice.NoticeStatus.hasBeenReleased.getId());
            notice.setReleaseTime(new Date());

        }else if(validType==1){
            String timeStr=request.getParameter("time");
            if (StringUtil.isEmpty(timeStr)) {
                retMap.put(Config.RET, 0);
                retMap.put(Config.ERR_MSG, "请选择待发布时间");
                return retMap;
            }
            Date time=DateUtil.parseDate(timeStr,"yyyy-MM-dd");
            notice.setStatus(Notice.NoticeStatus.toBeReleased.getId());
            notice.setReleaseTime(time);//暂时设置为当前时间，需要设置

        }
        notice.setUpdateTime(new Date());

        boolean b = false;

        try {
            b = noticeService.updateNotice(notice);

        }catch (Exception e){
            e.printStackTrace();
        }


        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }




}

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
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.service.IArticleTypeService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;


/**
 * @Auther: gk
 * @Date: 4/18/19 14 10
 * Description:
 */
@Controller
@RequestMapping("/manager/articleType")
public class ManagerArticleTypeController {

    @Autowired
    private IArticleTypeService articleTypeService;

    @GetMapping(value = "/articleTypeList")
    public String noticeList(HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/articleType/articleTypeList";
    }



    @GetMapping("/queryArticleType")
    @ResponseBody
    public Map<String,Object> queryArticleType(HttpServletRequest request, HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
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

        String name = request.getParameter("name");
        if (StringUtil.isNotEmpty(name)) {
            queryMap.put("name", name);
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

        int total = articleTypeService.getTotalAticleTypeCountByParams(queryMap);

        List<ArticleType> aticleTypes = articleTypeService.getAticleTypeByParams(queryMap);

        List<Map> resultMap = new ArrayList();

        for(int i = 0; i < aticleTypes.size(); i++) {
            ArticleType articleType = aticleTypes.get(i);


            String encId = IDEncryptor.getInstance().encryptWithoutException(articleType.getId());

            Map m = new HashMap();

            m.put("id", encId);

            m.put("name", articleType.getName());

            m.put("seq",articleType.getSeq());

            if (articleType.isAvailable()) {
                m.put("status", "有效");
            } else {
                m.put("status", "无效");
            }

            List<Action> actions = new ArrayList<Action>();
            m.put("opList", actions);

            if (articleType.isAvailable()) {
                Action disableAction = ActionFactory.build("禁用",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/articleType/setArticleTypeStatus?id=" + encId + "&status=0",
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(disableAction);
            } else {
                Action enableAction = ActionFactory.build("启用",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/articleType/setArticleTypeStatus?id=" + encId + "&status=1",
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(enableAction);
            }

            Action detailAction = ActionFactory.build("编辑",
                    "",
                    ActionFactory.TARGET_SELF,
                    ActionFactory.OPTYPE_SCRIPT ,
                    "/manager/articleType/updateArticleTypeById?id=" + encId,
                    ActionFactory.REQ_TYPE_DIV ,
                    "editArticleType");
            actions.add(detailAction);

            resultMap.add(m);
        }

        Map data = new HashMap();
        data.put("totalRows", total);
        data.put("nav", "");
        data.put("content", resultMap);
        retMap.put("data", data);

        return retMap;

    }


    @GetMapping("/getArrticleById")
    @ResponseBody
    public Map<String,Object> getArrticleById(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }
        String idStr = request.getParameter("id");

        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);

        ArticleType articleType = articleTypeService.getArticleTypetById(id);
        Map data = new HashMap();
        data.put("articleType", articleType);

        retMap.put("data", data);
        return retMap;
    }

    @RequestMapping("/setArticleTypeStatus")
    @ResponseBody
    public Map<String,Object> setArticleTypeStatus(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");

        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);

        ArticleType articleType = articleTypeService.getArticleTypetById(id);
        if(articleType == null){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "没有该类型");
            return  retMap;
        }
        String statusStr = request.getParameter("status");
        int status = Integer.valueOf(statusStr);
        articleType.setStatus(status);

        boolean b = false;

        try {
            b = articleTypeService.setArticleTypeStatus(articleType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }


    @RequestMapping("/addArticleType")
    @ResponseBody
    public Map<String,Object> addArticleType(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }
        List<ArticleType> articleTypes=articleTypeService.getArticleTypets();
        ArticleType articleType = new ArticleType();
        articleType.setCreateTime(new Date());
        String name = request.getParameter("name");
        for(ArticleType att : articleTypes){
            if(att.getName().equals(name)){
                retMap.put(Config.RET, 0);
                retMap.put(Config.ERR_MSG, "该类型已存在");
                return retMap;
            }

        }
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "类型名称不能为空");
            return retMap;
        }

        String seq = request.getParameter("seq");
        for(ArticleType att : articleTypes){
            if(att.getSeq()==Integer.parseInt(seq)){
                retMap.put(Config.RET, 0);
                retMap.put(Config.ERR_MSG, "当前已有同权重值的类型");
                return retMap;
            }

        }

        if (StringUtil.isEmpty(seq)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "权重值不可为空");
            return retMap;
        }

        articleType.setSeq(Integer.parseInt(seq));
        articleType.setName(name);
        articleType.setStatus(1);

        boolean b = false;
        try {
        	int result =articleTypeService.addArticleType(articleType);
        	if(result != 0) {
        		b = true;
        	}
        }catch (Exception e){
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }
        

        return retMap;
    }



    @RequestMapping("/updateArticleType")
    @ResponseBody
    public Map<String,Object> updateArticleType(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }
        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        ArticleType articleType = articleTypeService.getArticleTypetById(id);

        articleType.setUpdateTime(new Date());
        String name = request.getParameter("name");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "类型名称不能为空");
            return retMap;
        }
        articleType.setName(name);
        String seq = request.getParameter("seq");
        if (StringUtil.isEmpty(seq)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "权重值不可为空");
            return retMap;
        }
        articleType.setSeq(Integer.parseInt(seq));
        boolean b = false;

        try {
            b = articleTypeService.updateArticleType(articleType);
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

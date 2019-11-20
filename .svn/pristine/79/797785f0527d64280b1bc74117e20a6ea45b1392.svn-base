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
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleTypeService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

/**
 * @Auther: gk
 * @Date: 4/20/19 13 55
 * Description:
 */
@Controller
@RequestMapping("/manager/article")
public class ManagerArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IArticleTypeService articleTypeService;

    @Autowired
    private IBlogManagerService blogManagerService;

    @GetMapping("/articleList")
    public String articleList(HttpServletRequest request, HttpServletResponse response){
        List<ArticleType> articleTypes=articleTypeService.getArticleTypets();
        request.setAttribute("articleTypes",articleTypes);
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/article/articleList";
    }




    @GetMapping("/queryArticleList")
    @ResponseBody
    public Map<String,Object> queryArticleList(HttpServletRequest request, HttpServletResponse response){
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

        String typeId = request.getParameter("typeId");
        if (StringUtil.isNotEmpty(typeId)) {
            queryMap.put("typeId", typeId);
        }
        String blogName = request.getParameter("blogName");

        if (StringUtil.isNotEmpty(blogName)) {
            Blog blg=articleService.getBlogIdByName(blogName);
            queryMap.put("blogId", blg.getId());
        }

        String sDateStr = request.getParameter("sDate");
        Date sDate= DateUtil.parseDate(sDateStr,"yyyy-MM-dd");
        if (sDate!=null) {
            queryMap.put("sDate", sDate);
        }

        String eDateStr = request.getParameter("eDate");
        Date eDate= DateUtil.parseDate(eDateStr,"yyyy-MM-dd");
        if (eDate!=null) {
            queryMap.put("eDate", eDate);
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

        int total = articleService.getTotalArticleCountByParams(queryMap);

        List<Article> articles = articleService.getArticleByParams(queryMap);

        List<Map> resultMap = new ArrayList();

        for(int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);


            String encId = IDEncryptor.getInstance().encryptWithoutException(article.getId());
            ArticleType articleType=articleTypeService.getArticleTypetById(article.getTypeId());
            Blog blog=articleService.getBlogNameById(article.getBlogId());
            Map m = new HashMap();

            m.put("id", encId);

            m.put("number", article.getNumber());

            m.put("blogName", blog.getName());

            m.put("title", article.getTitle());
            
            if(articleType == null) {
            	m.put("TypeName", "");
            } else {
            	m.put("TypeName", StringUtil.isEmpty(articleType.getName()) ? "" : articleType.getName());
            }
            

            m.put("category", Article.ArticleCategory.getArticleCategory(article.getCategory()).getDesc());

            m.put("releaseTime", DateUtil.formatDate(article.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));

            m.put("status", Article.ArticleStatus.getArticleStatus(article.getStatus()).getDesc());

            List<Action> actions = new ArrayList<Action>();
            m.put("opList", actions);

             if(article.getStatus()==Article.ArticleStatus.toBeReleased.getId()||article.getStatus()==Article.ArticleStatus.hasBeenReleased.getId()){
                 Action disableAction = ActionFactory.build("下线",
                         "",
                         ActionFactory.TARGET_SELF,
                         ActionFactory.OPTYPE_SCRIPT ,
                         "/manager/article/setArticleStatus?id=" + encId + "&status=4",
                         ActionFactory.REQ_TYPE_CONFIRM ,
                         "");

                 actions.add(disableAction);
             }
            Action detailAction = ActionFactory.build("查看",
                    "/manager/article/articlrDetail?id=" + encId,
                    ActionFactory.TARGET_SELF,
                    ActionFactory.OPTYPE_LINK ,
                    "",
                    "" ,
                    "");
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


    @RequestMapping("/setArticleStatus")
    @ResponseBody
    public Map<String,Object> setArticleStatus(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");

        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);

        Article article = articleService.getArticleById(id);
        if(article == null){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "没有该文章");
            return  retMap;
        }
        String statusStr = request.getParameter("status");
        int status = Integer.valueOf(statusStr);
        article.setStatus(status);

        boolean b = false;

        try {
            b = articleService.setArticleStatus(article);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }




    @GetMapping("/articlrDetail")
    public String articleDetail(HttpServletRequest request,HttpServletResponse response) {

        String idStr=request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        Article article = articleService.getArticleById(id);
        request.setAttribute("article", article);
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        if(article!=null){
            ArticleType articleType=blogManagerService.getArticleTypeByArticlrId(article.getTypeId());
            request.setAttribute("articleType", articleType);
            Blog blog=articleService.getBlogNameById(article.getBlogId());
            request.setAttribute("blog", blog);
            BlogLabel blogLabel=articleService.getBlogLabelById(article.getLabelId());
            request.setAttribute("blogLabel", blogLabel);
        }
        return "../managers/article/articleDetail";
    }



}

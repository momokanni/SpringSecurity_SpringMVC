package com.caishen91.jupiter.controller.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.ShareTypeForRequest;
import com.caishen91.jupiter.service.IBlogLableService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.HtmlClient;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/blog/lable")
public class BlogLableController {

    @Autowired
    private IBlogLableService blogLableService;

    @Autowired
    private IBlogManagerService blogManagerService;
    
    @Autowired
    private IBlogPermitService blogPermitService;

    /**
     * @Auther: gk
     * @Date: 5/6/19 10 30
     * Description:标签管理页面
     */
    @RequestMapping("/lableList")
    public String noticeList(HttpServletRequest request, HttpServletResponse response){

    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);

        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
        request.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);

        //获该公众号标签
        List<BlogLabel> blogLabels=blogLableService.getLabelByBlogId(blog.getId());
        request.setAttribute("blogLabels",blogLabels);

        return "../blogPlatform/lableList";
    }
    
    @GetMapping("/labelDetail")
    @ResponseBody
    public Map<String, Object> getLabelDetail(@RequestParam String id){
    	Map<String, Object> retMap = new HashMap<>();
    	int labelId = IDEncryptor.getInstance().decryptWithoutException(id);
    	if(labelId == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "请选择栏目");
            return retMap;
    	}
    	BlogLabel blogLabel= blogLableService.getLabelById(labelId);
    	if(blogLabel == null) {
    		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "栏目不存在");
            return retMap;
    	}
    	retMap.put("data", JSONObject.toJSON(blogLabel));
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }




    /**
     * 	标签列表
     * @return
     */
    @GetMapping(value = "/queryLableList")
    @ResponseBody
    public Map<String, Object>  queryLableList(HttpServletRequest req,HttpServletResponse resp,BlogLabel blogLabel,
                                               @RequestParam(defaultValue = "0", required = false) String  pageNo,
                                               @RequestParam(defaultValue = "5", required = false) String iPageNo){
    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);
		
        Map<String, Object> retMap = new HashMap<>();
        // 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, iPageNo);
        String name = req.getParameter("name");

        if (StringUtil.isNotEmpty(name)) {
            paramMap.put("name", name);
        }
        String[] statuses = req.getParameterValues("status");
        if (statuses != null && statuses.length > 0) {
            List<Integer> sts = new ArrayList();
            for(String s : statuses) {
                sts.add(Integer.valueOf(s));
            }
            paramMap.put("statuses", sts);
        }
        paramMap.put("blogId", bm.getBlogId());

        List<BlogLabel> blogLabels = blogLableService.queryLableList(paramMap);

        blogLabels = dsplayDataAssem(blogLabels);
        Map<String, Object> data = CommonUtil.commonListData(0, blogLabels);
        retMap.put("data", data);
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }

    private List<BlogLabel> dsplayDataAssem(List<BlogLabel> blogLabels) {
        if (null != blogLabels && blogLabels.size() > 0) {
            for (BlogLabel blogLabel : blogLabels) {
                String idStr = IDEncryptor.getInstance().encryptWithoutException(blogLabel.getId());
                blogLabel.setIdStr(idStr);
                if(blogLabel.getStatus()==1){
                    blogLabel.setStatusStr("有效");
                }else{
                    blogLabel.setStatusStr("无效");
                }
            }

            return blogLabels;
        }
        return null;
    }



    /**
     * @Auther: gk
     * @Date: 5/6/19 11 28
     * Description:添加标签
     */


    @RequestMapping("/addLable")
    @ResponseBody
    public Map<String,Object> addLable(HttpServletRequest request, HttpServletResponse response,
                                                @RequestParam("name") String name, @RequestParam("scc") String scc,
                                                @RequestParam(required = false,value = "share") String share) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }
        
        name = name.trim();
        scc = scc.trim();
        BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);
		
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());

        BlogLabel blogLabel = new BlogLabel();
        BlogLabel nblogLabel=blogLableService.getLabelByName(name,blog.getId());
        if(nblogLabel!=null){
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "当前栏目已重复");
            return retMap;
        }
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "栏目名称不能为空");
            return retMap;
        }
        blogLabel.setName(name);

        if (StringUtil.isEmpty(scc)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "栏目描述不能为空");
            return retMap;
        }
        blogLabel.setDescription(scc);

        //获取公众号有效标签的条数
        int count=blogLableService.getLabelByStatus(blog.getId(),BlogLabel.LableStatus.yx.getId());
        if(count<7){
            blogLabel.setStatus(BlogLabel.LableStatus.yx.getId());
        }else{
            blogLabel.setStatus(BlogLabel.LableStatus.wx.getId());
        }
        blogLabel.setBlogId(blog.getId());
        blogLabel.setCreateTime(new Date());

        boolean b = false;

        try {
            b =blogLableService.addLable(blogLabel);
            if(StringUtil.isNotEmpty(share)) {
            	ShareTypeForRequest type = new ShareTypeForRequest();
                type.setFkId(IDEncryptor.getInstance().encryptWithoutException(blogLabel.getId()));
                type.setName(name);
                type.setSeq("");
                type.setStatus("1");
                String json = JSONObject.toJSONString(type);
                HtmlClient client = new HtmlClient();
             	OperationResult resp = client.postHtmlEx(Config.SHARE_TYPE_URL, json, "utf-8");
             	if(resp.isSuccess() != true) {
             		retMap.put(Config.RET, Config.RET_ERROR);
                    retMap.put(Config.ERR_MSG, "文章栏目推送至小油菜失败");
             	}
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



    /**
     * @Auther: gk
     * @Date: 5/6/19 14 10
     * Description:公众号标签启用/禁用
     */
    @PostMapping("/setBlogLabelStatus")
    @ResponseBody
    public Map<String, Object>  setBlogLabelStatus(@RequestParam("id") String id,@RequestParam(required = false,value = "share") String share) {
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	
        int blogLabelId = IDEncryptor.getInstance().decryptWithoutException(id);
        BlogLabel blogLabel = blogLableService.getLabelById(blogLabelId);
        if(blogLabel.getStatus()==BlogLabel.LableStatus.wx.getId()){
            blogLabel.setStatus(BlogLabel.LableStatus.yx.getId());
        }else{
            blogLabel.setStatus(BlogLabel.LableStatus.wx.getId());
        }
        blogLabel.setUpdateTime(new Date());
        
        if(!StringUtil.isEmpty(share)) {
        	ShareTypeForRequest type = new ShareTypeForRequest();
            type.setFkId(IDEncryptor.getInstance().encryptWithoutException(blogLabelId));
            type.setName(blogLabel.getName());
            type.setSeq("");
            type.setStatus(String.valueOf(blogLabel.getStatus()));
            String json = JSONObject.toJSONString(type);
            HtmlClient client = new HtmlClient();
         	OperationResult resp = client.postHtmlEx(Config.SHARE_TYPE_URL, json, "utf-8");
         	if(resp.isSuccess() != true) {
         		retMap.put(Config.RET, Config.RET_ERROR);
                retMap.put(Config.ERR_MSG, "文章栏目推送至小油菜失败");
                return retMap;
         	} else {
         		blogLableService.setBlogLabelStatus(blogLabel);
         	}
        } else {
        	blogLableService.setBlogLabelStatus(blogLabel);
        }
        
     	retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }





    /**
     * @Auther: gk
     * @Date: 5/6/19 15 38
     * Description:编辑公众号标签
     */
    @RequestMapping("/updateLable")
    @ResponseBody
    public Map<String,Object> updateLable(HttpServletRequest request, HttpServletResponse response,
    									  @RequestParam("name") String name,@RequestParam("scc") String scc,@RequestParam("id") String id,
    									  @RequestParam(required = false,value = "share") String share) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        BlogLabel blogLabel = blogLableService.getLabelById(Integer.valueOf(id));
        
        name = name.trim();
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "栏目名称不能为空");
            return retMap;
        }
        blogLabel.setName(name);

        scc = scc.trim();
        if (StringUtil.isEmpty(scc)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "栏目描述不能为空");
            return retMap;
        }
        blogLabel.setDescription(scc);
        blogLabel.setUpdateTime(new Date());

        boolean b = false;
        try {
        	b = blogLableService.updateLable(blogLabel);
        	if(StringUtil.isNotEmpty(share)) {
                 ShareTypeForRequest type = new ShareTypeForRequest();
                 type.setFkId(IDEncryptor.getInstance().encryptWithoutException(blogLabel.getId()));
                 type.setName(name);
                 type.setSeq("");
                 type.setStatus("1");
                 String json = JSONObject.toJSONString(type);
                 HtmlClient client = new HtmlClient();
              	OperationResult resp = client.postHtmlEx(Config.SHARE_TYPE_URL, json, "utf-8");
              	if(resp.isSuccess() != true) {
              		retMap.put(Config.RET, Config.RET_ERROR);
                     retMap.put(Config.ERR_MSG, "文章栏目推送至小油菜失败");
              	}
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


}

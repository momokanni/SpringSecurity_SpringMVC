package com.caishen91.jupiter.controller.blog;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.ArticleDTO;
import com.caishen91.jupiter.enums.BlogManagerType;
import com.caishen91.jupiter.enums.BlogType;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.model.SubBmAuthTree;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IBlogManagerPermitService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.service.INoticeService;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.JsonUtil;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.vo.ArticleVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/blog")
public class BlogPermitController {

	@Autowired
	private IBlogManagerService blogManagerService;
	
	@Autowired
	private IBlogPermitService blogPermitService;
	
	@Autowired
	private IBlogManagerPermitService blogManagerPermitService;
	
	@Autowired
	private IArticleService articleService;

	@Autowired
    private INoticeService noticeService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * @Auther: gk
	 * @Date: 4/24/19 10 10
	 * Description:首页展示
	 */
	@RequestMapping("/blogHome")
	public String newHome(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		BlogManagerDetailsModel bm = (BlogManagerDetailsModel) authentication.getPrincipal();


		//获取登陆用户的公众号信息  展示top页面个人信息
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bm.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bm.getBlogId());
		Blog blog=blogManagerService.getBlogById(blogId);
		request.setAttribute("blog", blog);
		BlogManager blogManager = blogManagerService.getBMById(bmId);
		request.setAttribute("blogManager", blogManager);
		
		List<BlogMenuTree> menuTree = blogPermitService.getMenu(blogId,bmId);
		request.setAttribute("menuTree",menuTree);

		//该公众号所有文章
		List<Article> articles=blogManagerService.getArticleByBlogId(blog.getId());
		request.setAttribute("articles",articles);
		int readCount=0;
		int collecCount=0;
		int forwardCount=0;
		Date date=new Date();
		if(articles != null && articles.size() > 0) {
			for(Article article : articles){
				int yesterdayCollecCount=blogManagerService.getYesterdayCollecCount(article.getId(),date);
				collecCount+=yesterdayCollecCount;
				int yesterdayReadCount=blogManagerService.getYesterdayReadCount(article.getId(),date);
				readCount+=yesterdayReadCount;
				int yesterdayForwardCount=blogManagerService.getYesterdayForwardCount(article.getId(),date);
				forwardCount+=yesterdayForwardCount;
			}
		}
		request.setAttribute("readCount",readCount);//昨日点击量
		request.setAttribute("collecCount",collecCount);//昨日收藏量
		request.setAttribute("forwardCount",forwardCount);//昨日转载量
		//昨日新增粉丝数
		int blogFocusYesterdayCount=blogManagerService.getBlogFocusCountByBlogIdYesterday(blog.getId(),date);
        request.setAttribute("blogFocusYesterdayCount",blogFocusYesterdayCount);

        //商户端公告
        int[] noticePlatform = {Notice.NoticeType.merchant.getId(),Notice.NoticeType.whole.getId()};
		Notice notice = blogManagerService.getNoticeByType(noticePlatform,Notice.NoticeStatus.hasBeenReleased.getId());
		request.setAttribute("notice",notice);
		//草稿(基于登陆账号本人)
		Article articleDraft=blogManagerService.getArticleDrafts(bmId,Article.ArticleStatus.draft.getId());
		request.setAttribute("articleDraft",articleDraft);

		//已发布内容(基于登陆账号本人已发布的文章)
		List<Article> articleLauched =blogManagerService.getArticleLauched (bmId,Article.ArticleStatus.hasBeenReleased.getId());
		request.setAttribute("articleLauched",articleLauched);
		return "../blogPlatform/index";
	}

    /**
     * @Auther: gk
     * @Date: 4/24/19 10 10
     * Description：已发布内容列表
     */
    @GetMapping(value = "/queryArlist")
    @ResponseBody
    public Map<String, Object> queryArlist(HttpServletRequest request,HttpServletResponse response,
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "5", required = false) String iPageNo, ArticleDTO arDto){
    	
		BlogManagerDetailsModel bm = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bm.getBlogId());
        Map<String, Object> retMap = new HashMap<>();
        // 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, iPageNo);
        paramMap.put("blogId", blogId);
        paramMap.put("status", Article.ArticleStatus.hasBeenReleased.getId());

        // 获取数据总数
        int total = 0;
        int count = articleService.queryArticleLaundCountByParamMap(paramMap);
        List<ArticleVO> arList = null;
        if (count > 0) {
            // 文章列表
            arList = articleService.queryForCustomerLaundByBlogId(paramMap);
            total = arList.size();
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "暂无数据");
            return retMap;
        }
        arList = dsplayDataAssem(arList);
        Map<String, Object> data = CommonUtil.commonListData(count, arList);
        data.put("actualCount", total);
        retMap.put("data", data);
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }


    private List<ArticleVO> dsplayDataAssem(List<ArticleVO> arList) {
        if (null != arList && arList.size() > 0) {
            for (ArticleVO arVO : arList) {
                String arIdStr = IDEncryptor.getInstance().encryptWithoutException(arVO.getId());
                arVO.setArId(arIdStr);
                // 发布时间
                arVO.setMmdd(DateUtil.formatDate(arVO.getReleaseTime(), "MM/dd"));
                arVO.setHhss(DateUtil.formatDate(arVO.getReleaseTime(), "HH:mm"));
            }

            return arList;
        }
        return null;
    }



    /**
     * @Auther: gk
     * @Date: 4/29/19 14 30
     * Description:最近草稿立即发布
     */
    @RequestMapping("/updateArticleDraft")
    @ResponseBody
    public Map<String,Object> updateArticleDraft(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String articleDraftIdStr = request.getParameter("articleDraftId");

        int articleDraftId = IDEncryptor.getInstance().decryptWithoutException(articleDraftIdStr);

        Article article = articleService.getArticleById(articleDraftId);

        article.setStatus(Article.ArticleStatus.hasBeenReleased.getId());

        article.setUpdateTime(new Date());
        article.setReleaseTime(new Date());

        boolean b = false;

        try {
            b = blogManagerService.updateArticleDraft(article);

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
	 * @Date: 4/25/19 11 10
	 * Description:点击已发布文章 跳转文章详情页
	 */
	@RequestMapping("/articleDetail")
	public String articleDetail(HttpServletRequest request,HttpServletResponse response) {

		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
		request.setAttribute("blogManager", bm);

		//获取登陆用户的公众号信息  展示top页面以及详情页个人信息
		Blog blog=blogManagerService.getBlogById(bm.getBlogId());
		request.setAttribute("blog", blog);
		
		List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);

		String idStr=request.getParameter("id");
		int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
		Article article = articleService.getArticleById(id);
		request.setAttribute("article", article);
		if(article!=null){
			ArticleType articleType=blogManagerService.getArticleTypeByArticlrId(article.getTypeId());
			request.setAttribute("articleType", articleType);
			BlogLabel blogLabel=articleService.getBlogLabelById(article.getLabelId());
            request.setAttribute("blogLabel", blogLabel);
		}
		return "../blogPlatform/articleDetail";
	}



    /**
     * @Auther: gk
     * @Date: 4/25/19 17 00
     * Description:跳转公告列表页
     */
    @RequestMapping("/noticeList")
    public String noticList(HttpServletRequest request,HttpServletResponse response) {

    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);

        //获取登陆用户的公众号信息  展示top页面以及详情页个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
        request.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);
		
        List<Notice> notices=blogManagerService.getBlogNoticeByType(Notice.NoticeType.insidePlatform.getId(),Notice.NoticeStatus.hasBeenReleased.getId());
        request.setAttribute("notices",notices);
        return "../blogPlatform/noticeList";
    }




    /**
     * @Auther: gk
     * @Date: 4/25/19 18 25
     * Description:跳转公告详情页
     */
    @RequestMapping("/noticeDetail")
    public String  noticeDetail(HttpServletRequest request,HttpServletResponse response) {
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);

        //获取登陆用户的公众号信息  展示top页面以及详情页个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
        request.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);

        String idStr=request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        Notice notice=noticeService.getNoticeById(id);
        request.setAttribute("notice",notice);
        return "../blogPlatform/noticeDetail";
    }



    /**
     * @Auther: gk
     * @Date: 4/26/19 10 30
     * Description:账号设置
     */
    @RequestMapping("/accountSetting")
    public String  accountSetting(HttpServletRequest request,HttpServletResponse response) {
    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);

        //获取登陆用户的公众号信息  展示top页面以及详情页个人信息
        Blog blog=blogManagerService.getBlogById(blogId);
        request.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blogId,bmId);
		request.setAttribute("menuTree",menuTree);

        return "../blogPlatform/accountSetting";
    }


    /**
     * @Auther: gk
     * @Date: 4/28/19 10 58
     * Description:账号设置修改
     */
    @RequestMapping("/updateBlog")
    @ResponseBody
    public Map<String,Object> updateBlog(HttpServletRequest request, HttpServletResponse response,
                                         @Param("blogName") String blogName, @Param("description") String description,
                                         @Param("email") String email,@RequestParam(value="pushUrl") String pushUrl) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String blogIdStr = request.getParameter("blogId");
        int blogId = IDEncryptor.getInstance().decryptWithoutException(blogIdStr);
        Blog blog = blogManagerService.getBlogById(blogId);

        Blog iBlog=blogManagerService.getBlogByName(blogName);
        if(iBlog!=null&&!blog.getName().equals(blogName)){
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "公众号名称已重复");
            return retMap;
        }
       if (StringUtil.isEmpty(blogName)) {
           retMap.put(Config.RET, 0);
           retMap.put(Config.ERR_MSG, "公众号名称不能为空");
           return retMap;
       }
       blog.setName(blogName);


       if (StringUtil.isEmpty(description)) {
           retMap.put(Config.RET, 0);
           retMap.put(Config.ERR_MSG, "公众号描述不能为空");
           return retMap;
       }
       blog.setDescription(description);
       if(blog.getType()== BlogType.COMPANY.getType()) {
            if (StringUtil.isEmpty(email)) {
                retMap.put(Config.RET, 0);
                retMap.put(Config.ERR_MSG, "公司邮箱不能为空");
                return retMap;
            }
           blog.setEmail(email);

       }

        blog.setUpdateTime(new Date());
        blog.setPushUrl(pushUrl);
        boolean b = false;

        try {
            b = blogManagerService.updateBlog(blog);

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
     * @Date: 4/28/19 10 58
     * Description:查找原密码
     */
    @RequestMapping("/findOldPwd")
    @ResponseBody
    public Map<String,Object> findOldPwd(HttpServletRequest request, HttpServletResponse response,
                                         @Param("id") int id,@Param("pwd")String pwd) {
        Map<String, Object> retMap = new HashMap<String, Object>();

        BlogManager blogManager = blogManagerService.getfindOldPwd(id);
        if(passwordEncoder.matches(pwd, blogManager.getPassword())){
            retMap.put(Config.RET, Config.RET_OK);
        }else{
            retMap.put(Config.RET, Config.RET_ERROR);
        }
        return retMap;
    }


    /**
     * @Auther: gk
     * @Date: 4/28/19 15 00
     * Description:账号设置密码修改
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    public Map<String,Object> updatePwd(@RequestParam("newPwd") String newPwd,@RequestParam("oldPwd") String oldPwd,
    									@RequestParam("pwdCas") String pwdCas,@RequestParam("blogMangerId") String blogMangerStr) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }
        
        if(StringUtil.isEmpty(oldPwd)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "原密码不能为空");
            return retMap;
        }

        if (StringUtil.isEmpty(newPwd)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "新密码不能为空");
            return retMap;
        }
        
        if (StringUtil.isEmpty(pwdCas)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "确认密码不能为空");
            return retMap;
        }
        
        if(!newPwd.equals(pwdCas)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "新密码和确认密码不一致");
            return retMap;
        }
        
        int blogMangerId = IDEncryptor.getInstance().decryptWithoutException(blogMangerStr);
        BlogManager blogManager = blogManagerService.getfindOldPwd(blogMangerId);
        
        if(!passwordEncoder.matches(oldPwd, blogManager.getPassword())) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "原密码错误");
            return retMap;
        }
        
        blogManager.setPassword(passwordEncoder.encode(newPwd));

        blogManager.setUpdateTime(new Date());

        boolean b = false;

        try {
            b = blogManagerService.updatePwd(blogManager);

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
     * @Date: 4/29/19 15 28
     * Description:子账号设置
     */
    @RequestMapping("/subaccountSetting")
    public String  subaccountSetting(HttpServletRequest request,HttpServletResponse response) {

    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);

        //获取登陆用户的公众号信息  展示top页面以及详情页个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
        request.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);

        //获取该公众号有效的子账号
        List<BlogManager> subBlogManagers=blogManagerService.getSubBlogManager(blog.getId(), BlogManagerType.NON_ADMIN.getType());
        request.setAttribute("subBlogManagers",subBlogManagers);
        return "../blogPlatform/subaccountSetting";
    }
    
    /**
     * 	获取超级管理员所有权限
     * @return
     */
    @GetMapping(value = "/getAuthorizes")
	@ResponseBody
	public Map<String, Object> getBmAuthorizes(@RequestParam String bmId) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		/**
		 * 	1. 获取当前商户号ID
		 * 	2. 获取当前商户号超级管理员ID
		 * 	3. 获取当前超级管理员权限  
		 * 	4. 获取当前操作的子账号已拥有的权限
		 * 	5. 组装数据
		 */
		int normalManagerId = IDEncryptor.getInstance().decryptWithoutException(bmId);
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int superbmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		List<SubBmAuthTree> tree = blogPermitService.getBmAuth(superbmId,normalManagerId,blogId);
		if(tree == null || tree.size() == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
	        retMap.put(Config.ERR_MSG,"获取权限异常");
	        return retMap;
		}
		
		JSONArray jsonArray = JsonUtil.extractNotNullAttr(tree);
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.RET_DATA,jsonArray);
        return retMap;
	}
    
    /**
     * 	给子账号赋权
     * @param ids
     * @param bmId
     * @return
     */
    @PostMapping("/subAccountBatchAuth")
    @ResponseBody
    public Map<String, Object> subAccountBatchAuth(@RequestParam String[] ids,String bmId){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	// 需要赋权的普通管理员ID
    	int managerId = IDEncryptor.getInstance().decryptWithoutException(bmId);
    	if(managerId == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "请选择需要授权的管理员");
    	}
    	
    	BlogManager normalManager = blogManagerService.getBMById(managerId);
    	if(normalManager == null) {
    		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "管理员不存在");
    	}
    	
    	BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	// 超级管理员ID
		int superId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		
		if(ids.length == 0){
			if(normalManager.getIsManager() == BlogManagerType.NON_ADMIN.getType()) {
				blogManagerPermitService.removeAllPermissionByBmIdAndBlogId(managerId,blogId);
				retMap.put(Config.RET, Config.RET_OK);
				return retMap;
			} 
			retMap.put(Config.RET, Config.RET_ERROR);
			return retMap;
    	}
    	/**
    	 * 	1. 取出超级管理员所有权限ID
    	 * 	2. 和要授权给普通管理员的权限ID集合，取交集
    	 * 	3. 将比对后的数据插入到数据库中
    	 * 	4. 最后更新缓存中的authentication
    	 */
		Set<String> result = new HashSet<String>();
		Set<String> idsSet = new HashSet<String>(Arrays.asList(ids));
		Set<String> superAuthIds = blogManagerPermitService.getManagerAuthPermission(superId, blogId);
		result.clear();
		result.addAll(idsSet);
		result.retainAll(superAuthIds);
		String[] endArray = result.toArray(new String[0]);
		
		try {
			blogManagerPermitService.updateBlogAuth(blogId, managerId, endArray);
			SecurityWebInitializer.setBMAuthMap(bmId);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_OK);
            retMap.put(Config.ERR_MSG, "操作失败");
            return retMap;
        }
		retMap.put(Config.RET, Config.RET_OK);
    	return retMap;
    }



    /**
     * @Auther: gk
     * @Date: 4/28/19 10 58
     * Description:查找手机号
     */
    @RequestMapping("/findMobile")
    @ResponseBody
    public Map<String,Object> findMobile(HttpServletRequest request, HttpServletResponse response, @Param("mobile")String mobile) {
        Map<String, Object> retMap = new HashMap<String, Object>();

        BlogManager blogManager= blogManagerService.getBlogManagerBymobile(mobile);
        if(blogManager==null){
            retMap.put(Config.RET, Config.RET_OK);
        }else{
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }






    /**
     * @Auther: gk
     * @Date: 4/29/19 14 58
     * Description:添加子账号
     */
    @RequestMapping("/addSubBlogManager")
    @ResponseBody
    public Map<String,Object> addSubBlogManager(HttpServletRequest request, HttpServletResponse response,
                                                @Param("name") String name, @Param("nickName") String nickName, @Param("mobile") String mobile) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());

        BlogManager blogManager = new BlogManager();

        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "姓名不能为空");
            return retMap;
        }
        blogManager.setName(name);

        BlogManager nblogManager= blogManagerService.getBlogManagerBynickname(nickName);
        if(nblogManager!=null){
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "该昵称已被注册");
            return retMap;
        }else if (StringUtil.isEmpty(nickName)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "昵称不能为空");
            return retMap;
        }
        
        if(StringUtil.isEmpty(mobile)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "手机号不能为空");
            return retMap;
        }
        
        if(!CommonUtil.isMobile(mobile)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "请正确填写手机号");
            return retMap;
        }
        BlogManager mblogManager= blogManagerService.getBlogManagerBymobile(mobile);
        if(mblogManager!=null){
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "该手机号已被使用");
            return retMap;
        }else if (StringUtil.isEmpty(mobile)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "手机号不能为空");
            return retMap;
        }

        blogManager.setNickName(nickName);

        blogManager.setMobile(mobile);

        blogManager.setPassword(passwordEncoder.encode(Config.DEFAULT_PASSWORD));

        blogManager.setIsManager(BlogManagerType.NON_ADMIN.getType());

        blogManager.setStatus(BlogManager.BlogManagerStatus.EFFECTIVE.getStatus());

        blogManager.setBlogId(blog.getId());

        blogManager.setCreateTime(new Date());
        
        
        
        boolean b = false;

        try {
            b =blogManagerService.addSubBlogManager(blogManager);
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
     * @Date: 4/29/19 14 58
     * Description:子账号禁用/启用
     */
    @RequestMapping("/setBlogManagerStatus")
    public String  setSubBlogManagerStatus(HttpServletRequest request,HttpServletResponse response) {
        String blogMangerIdStr = request.getParameter("id");
        int blogMangerId = IDEncryptor.getInstance().decryptWithoutException(blogMangerIdStr);
        BlogManager blogManager = blogManagerService.getfindOldPwd(blogMangerId);
        if(blogManager.getStatus()==BlogManager.BlogManagerStatus.INVALID.getStatus()){
            blogManager.setStatus(BlogManager.BlogManagerStatus.EFFECTIVE.getStatus());
        }else{
            blogManager.setStatus(BlogManager.BlogManagerStatus.INVALID.getStatus());
        }
        blogManager.setUpdateTime(new Date());
        blogManagerService.setSubBlogManagerStatus(blogManager);
        SecurityWebInitializer.setBMStatusMap(blogMangerIdStr);
        return "redirect:/blog/subaccountSetting";
    }



    /**
     * @Auther: gk
     * @Date: 4/29/19 14 58
     * Description:子账号重置密码
     */
    @RequestMapping("/resetPwd")
    @ResponseBody
    public Map<String,Object> resetPwd(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("subBlogManagerId");
        int sublogMangerId = IDEncryptor.getInstance().decryptWithoutException(idStr);
        BlogManager blogManager = blogManagerService.getfindOldPwd(sublogMangerId);

        blogManager.setPassword(passwordEncoder.encode(Config.DEFAULT_PASSWORD));
        blogManager.setUpdateTime(new Date());
        boolean b=false;
        try {
            b =blogManagerService.resetPwd(blogManager);

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

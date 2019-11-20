package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeClique;
import com.caishen91.jupiter.model.FaeIssue;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IFaeICliqueService;
import com.caishen91.jupiter.service.IFaeIssueService;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 35
 * Description:
 */

@Controller
@RequestMapping("/manager/issue")
public class ManagerIssueController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeIssueService faeIssueService;

    @Autowired
    private IFaeICliqueService faeICliqueService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeIssueService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/getIssueBySgt")
    @ResponseBody
    public Map<String,Object> getIssueBySgt(){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String keys = request.getParameter("k");

        List<FaeIssue> issueList = faeIssueService.getFaeIssueByName(keys);

        List<Map> rets = new ArrayList();

        for(FaeIssue issue : issueList) {
            Map r = new HashMap();

            r.put("id", IDEncryptor.getInstance().encryptWithoutException(issue.getId()));
            r.put("name", issue.getName() );

            rets.add(r);
        }

        retMap.put("data", rets);

        return retMap;

    }

    @RequestMapping("/addFaeIssue")
    @ResponseBody
    public Map<String,Object> addFaeDanbao() {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put(Config.RET, Config.RET_OK);

        String name = request.getParameter("name");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.ERR_MSG, "公司全称不能为空");
        }

        String shortName = request.getParameter("shortName");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.ERR_MSG, "公司简称不能为空");
        }

        String creditCode = request.getParameter("creditCode");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.ERR_MSG, "统一社会信用代码不能为空");
        }

        FaeIssue faeIssue = new FaeIssue();
        faeIssue.setName(name);
        faeIssue.setShortName(shortName);
        faeIssue.setCreditCode(creditCode);
        faeIssue.setCreateTime(new Date());

        String cliqueIdStr = request.getParameter("cliqueId");
        if (StringUtil.isNotEmpty(cliqueIdStr) && ValidateUtil.isNumber(cliqueIdStr)) {
            faeIssue.setCliqueId(IDEncryptor.getInstance().decryptWithoutException(cliqueIdStr));
        }

        try{
            faeIssueService.addFaeIssue(faeIssue);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toIssueList")
    public String toIssueList() {
        return "/manager/member/faeIssue/faeIssueList";
    }

    @RequestMapping("/queryFaeIssueList")
    @ResponseBody
    public Map<String,Object> queryFaeIssueList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String shortName,
            @RequestParam(value = "cliqueId", required = false) String cliqueIdStr) {

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("shortName", shortName);
        if (StringUtil.isNotEmpty(cliqueIdStr) && ValidateUtil.isNumber(cliqueIdStr)) {
            paramMap.put("cliqueId", IDEncryptor.getInstance().decryptWithoutException(cliqueIdStr));
        }

        try {
            int pageNoInt = Integer.parseInt(pageNo);
            int perPageNoInt = Integer.parseInt(perPageNo);
            int offset = (pageNoInt - 1) * perPageNoInt;
            paramMap.put("offset", offset);
            paramMap.put("pageCount", perPageNoInt);
        } catch (Exception e) {
            e.printStackTrace();
            paramMap.put("offset", 0);
            paramMap.put("pageCount", 10);
        }

        int count = faeIssueService.queryFaeIssueCountByParam(paramMap);
        List<FaeIssue> faeIssues = null;
        if (count > 0) {
            faeIssues = faeIssueService.queryFaeIssueListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeIssues && faeIssues.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeIssue faeIssue : faeIssues) {
                Map<String, Object> resultMap = new HashMap<>();

                String issueIdStr = IDEncryptor.getInstance().encryptWithoutException(faeIssue.getId());
                FaeClique faeClique = faeICliqueService.getFaeCliqueById(faeIssue.getCliqueId());
                resultMap.put("number", faeIssue.getId());
                resultMap.put("shortName", faeIssue.getShortName());
                resultMap.put("creditCode", faeIssue.getCreditCode());
                if (null != faeClique) {
                    resultMap.put("cliqueName", faeClique.getShortName());
                }

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/issue/getFaeIssueDetailById?id=" + issueIdStr,ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_LINK,"",ActionFactory.REQ_TYPE_LINK,"");

                actions.add(detailAction);
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
            }

            Map<String, Object> data = new HashMap<>();
            data.put("totalRows", count);
            data.put("nav", "");
            data.put("content", listResultMap);
            retMap.put("data", data);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

    @RequestMapping("/getFaeIssueDetailById")
    public String getFaeCliqueDetailById(@RequestParam(value = "id", defaultValue = "") String issueIdStr) {

        int issueId = IDEncryptor.getInstance().decryptWithoutException(issueIdStr);
        FaeIssue faeIssue = faeIssueService.getFaeIssueById(issueId);
        FaeClique faeClique = faeICliqueService.getFaeCliqueById(faeIssue.getCliqueId());


        request.setAttribute("faeIssue", faeIssue);
        if (null != faeClique && StringUtil.isNotEmpty(faeClique.getShortName())) {
            request.setAttribute("cliqueName", faeClique.getShortName());
        }

        return "/manager/member/faeIssue/faeIssueDetail";
    }
}

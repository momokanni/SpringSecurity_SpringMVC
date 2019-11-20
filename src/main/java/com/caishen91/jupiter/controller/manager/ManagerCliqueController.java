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
 * @Date: 3/15/19 16 24
 * Description:
 */
@Controller
@RequestMapping("/manager/clique")
public class ManagerCliqueController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeICliqueService faeICliqueService;

    @Autowired
    private IFaeIssueService faeIssueService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeICliqueService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/getFaeCliqueByName")
    @ResponseBody
    public Map<String,Object> getFaeCliqueByName(@RequestParam(value = "k", required = false) String cliqueName) {
        Map<String,Object> retMap = new HashMap<String,Object>();

        List<FaeClique> faeCliques = faeICliqueService.getFaeCliqueByName(cliqueName);
        if (null != faeCliques && faeCliques.size() > 0) {
            List<Map<String,Object>> resultMapList = new ArrayList();
            for (FaeClique faeClique : faeCliques) {
                Map<String,Object> resultMap = new HashMap();
                resultMap.put("id", IDEncryptor.getInstance().encryptWithoutException(faeClique.getId()));
                resultMap.put("name", faeClique.getName());
                resultMapList.add(resultMap);
            }
            retMap.put("data", resultMapList);
        }

        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }

    @RequestMapping("/addFaeClique")
    @ResponseBody
    public Map<String,Object> addFaeClique() {
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

        FaeClique clique = faeICliqueService.getFaeCliqueByCreditCode(creditCode);
        if (null != clique) {
            retMap.put(Config.ERR_MSG, "该集团已存在");
        }

        if (StringUtil.isNotEmpty((String)retMap.get(Config.ERR_MSG))) {
            retMap.put(Config.RET, Config.RET_ERROR);
            return retMap;
        }

        FaeClique faeClique = new FaeClique();
        faeClique.setName(name);
        faeClique.setShortName(shortName);
        faeClique.setCreditCode(creditCode);
        faeClique.setCreateTime(new Date());

        try{
            faeICliqueService.addFaeClique(faeClique);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toCliqueList")
    public String toCliqueList() {
        return "/manager/member/faeClique/faeCliqueList";
    }

    @RequestMapping("/queryFaeCliqueList")
    @ResponseBody
    public Map<String,Object> queryFaeCliqueList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String shortName, String startTime, String endTime) {

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("shortName", shortName);
        if (StringUtil.isNotEmpty(startTime)) {
            paramMap.put("startTime", startTime + " 00:00:00");
        }
        if (StringUtil.isNotEmpty(endTime)) {
            paramMap.put("endTime", endTime + " 23:59:59");
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

        int count = faeICliqueService.queryFaeCliqueCountByParam(paramMap);
        List<FaeClique> faeCliques = null;
        if (count > 0) {
            faeCliques = faeICliqueService.queryFaeCliqueListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeCliques && faeCliques.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeClique faeClique : faeCliques) {
                Map<String, Object> resultMap = new HashMap<>();

                String cliqueIdStr = IDEncryptor.getInstance().encryptWithoutException(faeClique.getId());
                int countFaeIssue = faeIssueService.getFaeIssueCountByCliqueId(faeClique.getId());
                resultMap.put("number", faeClique.getId());
                resultMap.put("shortName", faeClique.getShortName());
                resultMap.put("creditCode", faeClique.getCreditCode());
                if (0 >= countFaeIssue) {
                    resultMap.put("issueCount", "-");
                } else {
                    resultMap.put("issueCount", countFaeIssue);
                }

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/clique/getFaeCliqueDetailById?id=" + cliqueIdStr,ActionFactory.TARGET_SELF,
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

    @RequestMapping("/getFaeCliqueDetailById")
    public String getFaeCliqueDetailById(@RequestParam(value = "id", defaultValue = "") String cliqueIdStr) {

        int cliqueId = IDEncryptor.getInstance().decryptWithoutException(cliqueIdStr);
        FaeClique faeClique = faeICliqueService.getFaeCliqueById(cliqueId);
        List<FaeIssue> faeIssues = faeIssueService.getFaeIssueByCliqueId(cliqueId);
        List<String> faeIssueShortNames = new ArrayList<>();
        faeIssues.forEach((issue) -> faeIssueShortNames.add(issue.getShortName()));

        request.setAttribute("faeClique", faeClique);
        request.setAttribute("faeIssueShortNames", faeIssueShortNames);

        return "/manager/member/faeClique/faeCliqueDetail";
    }
}

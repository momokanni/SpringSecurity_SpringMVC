package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeUnderwriter;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IFaeUnderwriterService;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 24
 * Description:
 */
@Controller
@RequestMapping("/manager/underwriter")
public class ManagerUnderwriterController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeUnderwriterService faeUnderwriterService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeUnderwriterService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/getUnderwriterBySgt")
    @ResponseBody
    public Map<String,Object> getIssueBySgt(){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String keys = request.getParameter("k");

        List<FaeUnderwriter> uwList = faeUnderwriterService.getFaeUnderwriterBySgt(keys);

        List<Map> rets = new ArrayList();

        for(FaeUnderwriter uw : uwList) {
            Map r = new HashMap();

            r.put("id", IDEncryptor.getInstance().encryptWithoutException(uw.getId()));
            r.put("name", uw.getName() );

            rets.add(r);
        }

        retMap.put("data", rets);

        return retMap;

    }

    @RequestMapping("/addFaeUnderwriter")
    @ResponseBody
    public Map<String,Object> addFaeUnderwriter(HttpServletResponse response) {
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

        FaeUnderwriter faeUnderwriter = new FaeUnderwriter();
        faeUnderwriter.setName(name);
        faeUnderwriter.setShortName(shortName);
        faeUnderwriter.setCreditCode(creditCode);
        faeUnderwriter.setCreateTime(new Date());

        try{
            faeUnderwriterService.addFaeUnderwriter(faeUnderwriter);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toUnderwriterList")
    public String toUnderwriterList() {
        return "/manager/member/faeUnderwriter/faeUnderwriterList";
    }

    @RequestMapping("/queryFaeUnderwriterList")
    @ResponseBody
    public Map<String,Object> queryFaeUnderwriterList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String shortName){

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("shortName", shortName);

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

        int count = faeUnderwriterService.queryFaeUnderwriterCountByParam(paramMap);
        List<FaeUnderwriter> faeUnderwriters = null;
        if (count > 0) {
            faeUnderwriters = faeUnderwriterService.queryFaeUnderwriterListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeUnderwriters && faeUnderwriters.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeUnderwriter faeUnderwriter : faeUnderwriters) {
                Map<String, Object> resultMap = new HashMap<>();

                String underwriterIdStr = IDEncryptor.getInstance().encryptWithoutException(faeUnderwriter.getId());
                resultMap.put("number", faeUnderwriter.getId());
                resultMap.put("shortName", faeUnderwriter.getShortName());
                resultMap.put("creditCode", faeUnderwriter.getCreditCode());

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/underwriter/getFaeUnderwriterDetailById?id=" + underwriterIdStr,ActionFactory.TARGET_SELF,
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

    @RequestMapping("/getFaeUnderwriterDetailById")
    public String getFaeUnderwriterDetailById(@RequestParam(value = "id", defaultValue = "") String underwriterIdStr) {

        int underwriterId = IDEncryptor.getInstance().decryptWithoutException(underwriterIdStr);
        FaeUnderwriter faeUnderwriter = faeUnderwriterService.getFaeUnderwriterById(underwriterId);


        request.setAttribute("faeUnderwriter", faeUnderwriter);

        return "/manager/member/faeUnderwriter/faeUnderwriterDetail";
    }
}

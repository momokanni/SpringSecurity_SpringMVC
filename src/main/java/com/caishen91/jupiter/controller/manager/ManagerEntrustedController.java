package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeEntrusted;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IFaeEntrustedService;
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
@RequestMapping("/manager/entrusted")
public class ManagerEntrustedController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeEntrustedService faeEntrustedService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeEntrustedService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/getEntrustedBySgt")
    @ResponseBody
    public Map<String,Object> getIssueBySgt(){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String keys = request.getParameter("k");

        List<FaeEntrusted> faeEntrusteds = faeEntrustedService.getFaeEntrustedBySgt(keys);

        List<Map> rets = new ArrayList();

        for(FaeEntrusted db : faeEntrusteds) {
            Map r = new HashMap();

            r.put("id", IDEncryptor.getInstance().encryptWithoutException(db.getId()));
            r.put("name", db.getName() );

            rets.add(r);
        }

        retMap.put("data", rets);

        return retMap;

    }

    @RequestMapping("/addFaeEntrusted")
    @ResponseBody
    public Map<String,Object> addFaeEntrusted(HttpServletResponse response) {
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

        FaeEntrusted faeEntrusted = new FaeEntrusted();
        faeEntrusted.setName(name);
        faeEntrusted.setShortName(shortName);
        faeEntrusted.setCreditCode(creditCode);
        faeEntrusted.setCreateTime(new Date());

        try{
            faeEntrustedService.addFaeEntrusted(faeEntrusted);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toEntrustedList")
    public String toEntrustedList() {
        return "/manager/member/faeEntrusted/faeEntrustedList";
    }

    @RequestMapping("/queryFaeEntrustedList")
    @ResponseBody
    public Map<String,Object> queryFaeEntrustedList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String shortName) {

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

        int count = faeEntrustedService.queryFaeEntrustedCountByParam(paramMap);
        List<FaeEntrusted> faeEntrusteds = null;
        if (count > 0) {
            faeEntrusteds = faeEntrustedService.queryFaeEntrustedListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeEntrusteds && faeEntrusteds.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeEntrusted faeEntrusted : faeEntrusteds) {
                Map<String, Object> resultMap = new HashMap<>();

                String entrustedIdStr = IDEncryptor.getInstance().encryptWithoutException(faeEntrusted.getId());
                resultMap.put("number", faeEntrusted.getId());
                resultMap.put("shortName", faeEntrusted.getShortName());
                resultMap.put("creditCode", faeEntrusted.getCreditCode());

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/entrusted/getFaeEntrustedDetailById?id=" + entrustedIdStr,ActionFactory.TARGET_SELF,
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

    @RequestMapping("/getFaeEntrustedDetailById")
    public String getFaeCliqueDetailById(@RequestParam(value = "id", defaultValue = "") String entrustedIdStr) {

        int entrustedId = IDEncryptor.getInstance().decryptWithoutException(entrustedIdStr);
        FaeEntrusted faeEntrusted = faeEntrustedService.getFaeEntrustedById(entrustedId);


        request.setAttribute("faeEntrusted", faeEntrusted);

        return "/manager/member/faeEntrusted/faeEntrustedDetail";
    }
}

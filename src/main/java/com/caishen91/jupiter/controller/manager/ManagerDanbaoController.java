package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeDanbao;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IFaeDanbaoService;
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
@RequestMapping("/manager/danbao")
public class ManagerDanbaoController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeDanbaoService faeDanbaoService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeDanbaoService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/getDanbaoBySgt")
    @ResponseBody
    public Map<String,Object> getIssueBySgt(){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String keys = request.getParameter("k");

        List<FaeDanbao> dbList = faeDanbaoService.getFaeDanbaoBySgt(keys);

        List<Map> rets = new ArrayList();

        for(FaeDanbao db : dbList) {
            Map r = new HashMap();

            r.put("id", IDEncryptor.getInstance().encryptWithoutException(db.getId()));
            r.put("name", db.getName() );

            rets.add(r);
        }

        retMap.put("data", rets);

        return retMap;

    }

    @RequestMapping("/addFaeDanbao")
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

        FaeDanbao faeDanbao = new FaeDanbao();
        faeDanbao.setName(name);
        faeDanbao.setShortName(shortName);
        faeDanbao.setCreditCode(creditCode);
        faeDanbao.setCreateTime(new Date());

        try{
            faeDanbaoService.addFaeDanbao(faeDanbao);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toDanbaoList")
    public String toDanbaoList() {
        return "/manager/member/faeDanbao/faeDanbaoList";
    }

    @RequestMapping("/queryFaeDanbaoList")
    @ResponseBody
    public Map<String,Object> queryFaeDanbaoList(
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

        int count = faeDanbaoService.queryFaeanbaoCountByParam(paramMap);
        List<FaeDanbao> faeDanbaos = null;
        if (count > 0) {
            faeDanbaos = faeDanbaoService.queryFaeDanbaoListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeDanbaos && faeDanbaos.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeDanbao faeDanbao : faeDanbaos) {
                Map<String, Object> resultMap = new HashMap<>();

                String danbaoIdStr = IDEncryptor.getInstance().encryptWithoutException(faeDanbao.getId());
                resultMap.put("number", faeDanbao.getId());
                resultMap.put("shortName", faeDanbao.getShortName());
                resultMap.put("creditCode", faeDanbao.getCreditCode());

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/danbao/getFaeDanbaoDetailById?id=" + danbaoIdStr,ActionFactory.TARGET_SELF,
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

    @RequestMapping("/getFaeDanbaoDetailById")
    public String getFaeDanbaoDetailById(@RequestParam(value = "id", defaultValue = "") String danbaoIdStr) {
        int danbaoId = IDEncryptor.getInstance().decryptWithoutException(danbaoIdStr);
        FaeDanbao faeDanbao = faeDanbaoService.getFaeDanbaoById(danbaoId);
        request.setAttribute("faeDanbao", faeDanbao);

        return "/manager/member/faeDanbao/faeDanbaoDetail";
    }
}

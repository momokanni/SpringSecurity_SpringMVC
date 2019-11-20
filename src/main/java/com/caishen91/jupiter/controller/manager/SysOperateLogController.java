package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.SysDepartment;
import com.caishen91.jupiter.service.ISysOperateLogService;
import com.caishen91.jupiter.util.*;
import com.caishen91.jupiter.vo.SysOperateLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/27/19 17 57
 * Description:
 */
@Controller
@RequestMapping("/manager/sysLog")
public class SysOperateLogController {

    @Autowired
    private ISysOperateLogService sysOperateLogService;


    @RequestMapping("/sysLog")
    public String sysLog(){
        return "/manager/system/operateLog";
    }

    @RequestMapping("/querySysOperateLog")
    @ResponseBody
    public Map<String,Object> queryFaeIssueList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo) {

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);


        Map<String, Object> paramMap = new HashMap();

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

        int count = sysOperateLogService.querySysLogCountByParam(paramMap);
        List<SysOperateLogVo> logs = null;
        if (count > 0) {
            logs = sysOperateLogService.querySysLogByParam(paramMap);
        }

        if (null != logs && logs.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (SysOperateLogVo log : logs) {
                Map<String, Object> resultMap = new HashMap<>();

                String issueIdStr = IDEncryptor.getInstance().encryptWithoutException(log.getId());
                resultMap.put("sysName", log.getName());
                String departmentName = SysDepartment.getSysDepartment(log.getDepartment()).getDesc();
                resultMap.put("roleName", departmentName + log.getRoleName());
                resultMap.put("logMessage", log.getLogMessage());
                resultMap.put("createTime", DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(log.getCreateTime()));
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
}

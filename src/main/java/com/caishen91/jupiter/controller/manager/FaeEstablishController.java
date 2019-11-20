package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeEstablishInfo;
import com.caishen91.jupiter.service.IFaeEstablishService;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/manager/establish")
public class FaeEstablishController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeEstablishService faeEstablishService;



    @RequestMapping("/queryEstablishInfo")
    @ResponseBody
    public Map<String,Object> queryInvestRecord(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String productId
           ) {

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

        if(StringUtil.isNotEmpty(productId)){
            int pid = IDEncryptor.getInstance().decryptWithoutException(productId);
            paramMap.put("productId", pid);
        }

        //起始时间
        String sDate = request.getParameter("sDate");
        Date startTime = null;
        if(StringUtil.isNotEmpty(sDate)){
            startTime = DateUtil.parseDate(sDate, "yyyy-MM-dd");
            paramMap.put("startTime", startTime);
        }

        //结束时间
        String eDate = request.getParameter("eDate");
        Date endTime = null;
        if(StringUtil.isNotEmpty(eDate)){
            endTime = DateUtil.parseDate(eDate, "yyyy-MM-dd");
            paramMap.put("endTime", endTime);
        }

        int count = faeEstablishService.queryFaeEstablishInfoCountByParam(paramMap);
        List<FaeEstablishInfo> feis = null;
        if (count > 0) {
            feis = faeEstablishService.queryFaeEstablishInfoByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != feis && feis.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeEstablishInfo fei : feis) {
                Map<String, Object> resultMap = new HashMap<>();

                String recordIdStr = IDEncryptor.getInstance().encryptWithoutException(fei.getId());

                resultMap.put("phase",fei.getPhase());
                resultMap.put("establishDate",DateUtil.formatDate(fei.getEstablishDate(),"yyyy-MM-dd"));
                resultMap.put("dueDate",DateUtil.formatDate(fei.getEstablishDate(),"yyyy-MM-dd"));
                resultMap.put("establishAmount",FormatUtil.formatCurrency(fei.getEstablishAmount()));
                resultMap.put("buyCount",fei.getBuyCount());

                resultMap.put("status", FaeEstablishInfo.EstablishStatus.getFaeEstablishStatusByStatus(fei.getStatus()).getDesc());

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

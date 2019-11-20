package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeRepayInfo;
import com.caishen91.jupiter.service.IFaeRepayInfoService;
import com.caishen91.jupiter.util.*;
import com.caishen91.jupiter.vo.FaeRepayInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 24
 * Description:
 */
@Controller
@RequestMapping("/manager/repayInfo")
public class FaeRepayInfoController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeRepayInfoService faeRepayInfoService;



    @RequestMapping("/sureRepay")
    @ResponseBody
    public Map<String,Object> sureRepay(){
        Map<String, Object> retMap = new HashMap<>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }


        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        FaeRepayInfo repayInfoById = faeRepayInfoService.getRepayInfoById(id);

        repayInfoById.setRepayStatus(FaeRepayInfo.RepayStatus.repayed.getStatus());

        boolean b = faeRepayInfoService.updateRepayInfoStatus(repayInfoById);
        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }
        return retMap;

    }



    @RequestMapping("/queryRepayInfo")
    @ResponseBody
    public Map<String,Object> queryInvestRecord(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String productId,String repayStatus,String productName,String issueName) {

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

        if(StringUtil.isNotEmpty(repayStatus)){
            int status = StringUtil.parseInt(repayStatus,-1);
            paramMap.put("repayStatus", status);
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



        if(StringUtil.isNotEmpty(productName)){
            paramMap.put("productName", productName);
        }

        if(StringUtil.isNotEmpty(issueName)){
            paramMap.put("issueName", issueName);
        }


        Map countMap = faeRepayInfoService.queryFaeRepayInfoCountMapByParam(paramMap);

        BigDecimal repayPrincipal = BigDecimal.ZERO;
        if(countMap.get("repayPrincipal") != null){
            repayPrincipal = StringUtil.parseDecimal(countMap.get("repayPrincipal") + "",DecimalUtil.Minus1);
        }
        BigDecimal repayInterest = BigDecimal.ZERO;
        if(countMap.get("repayInterest") != null){
            repayInterest = StringUtil.parseDecimal(countMap.get("repayInterest") + "",DecimalUtil.Minus1);
        }

        int count = StringUtil.parseInt(countMap.get("count")+ "",0);


        List<FaeRepayInfoVo> repayInfoVos = null;
        if (count > 0) {
            repayInfoVos = faeRepayInfoService.queryFaeRepayInfoByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        Date today = new Date();

        if (null != repayInfoVos && repayInfoVos.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeRepayInfoVo repayInfoVo : repayInfoVos) {
                Map<String, Object> resultMap = new HashMap<>();

                String recordIdStr = IDEncryptor.getInstance().encryptWithoutException(repayInfoVo.getId());

                resultMap.put("phase",repayInfoVo.getEstablishPhase() +"/" +repayInfoVo.getRepayPhase());
                resultMap.put("repayDate",DateUtil.formatDate(repayInfoVo.getRepayDate(),"yyyy-MM-dd"));

                resultMap.put("leftDay",DateUtil.getLeftDay(repayInfoVo.getRepayDate(),today));


                resultMap.put("productName",repayInfoVo.getProductName());
                resultMap.put("issueName",repayInfoVo.getIssueName());


                resultMap.put("repayPrincipal",FormatUtil.formatCurrency(repayInfoVo.getRepayPrincipal()));
                resultMap.put("repayInterest",FormatUtil.formatCurrency(repayInfoVo.getRepayInterest()));

                resultMap.put("totalRepay",FormatUtil.formatCurrency(repayInfoVo.getRepayPrincipal().add(repayInfoVo.getRepayInterest()).setScale(2,BigDecimal.ROUND_HALF_EVEN)));


                resultMap.put("repayStatus",FaeRepayInfo.RepayStatus.getRepayStatusByStatus(repayInfoVo.getRepayStatus()).getDesc());

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/repayPhase/repayPhaseByRepayInfo?id=" + recordIdStr,ActionFactory.TARGET_BLANK,
                        ActionFactory.OPTYPE_LINK,"",ActionFactory.REQ_TYPE_LINK,"");

                actions.add(detailAction);
                if(repayInfoVo.getRepayStatus() != FaeRepayInfo.RepayStatus.repayed.getStatus()){
                    Action repaySureAction =  ActionFactory.build("还款确认","","",
                            ActionFactory.OPTYPE_SCRIPT,"/manager/repayInfo/sureRepay?id=" + recordIdStr,ActionFactory.REQ_TYPE_CONFIRM,"");
                    actions.add(repaySureAction);
                }

                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
            }

            Map<String, Object> data = new HashMap<>();
            data.put("totalRows", count);
            data.put("nav", "");
            data.put("content", listResultMap);

            Map totalHeader = new HashMap();
            totalHeader.put("total", count);
            totalHeader.put("totalRepay", FormatUtil.formatCurrency(repayPrincipal.add(repayInterest)));
            data.put("totalHeader", totalHeader);

            retMap.put("data", data);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

}

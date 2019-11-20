package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeInvestRecord;
import com.caishen91.jupiter.model.FaeInvestor;
import com.caishen91.jupiter.service.IFaeInvestRecordService;
import com.caishen91.jupiter.util.*;
import com.caishen91.jupiter.vo.FaeInvestRecordVo;
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
@RequestMapping("/manager/investRecord")
public class InvestRecordController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeInvestRecordService faeInvestRecordService;



    @RequestMapping("/queryInvestRecord")
    @ResponseBody
    public Map<String,Object> queryInvestRecord(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String productId,String investorId,String orderBy) {

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

        String sortField = request.getParameter("sortField");

        if(StringUtil.isNotEmpty(sortField)){
            paramMap.put("sortField", sortField);
        }

        if(StringUtil.isNotEmpty(orderBy)){
            paramMap.put("orderBy", orderBy);
        }

        if(StringUtil.isNotEmpty(investorId)){
            int uid = IDEncryptor.getInstance().decryptWithoutException(investorId);
            paramMap.put("investorId", uid);
        }

        String status = request.getParameter("flag");

        if(StringUtil.isNotEmpty(status)){
            List<Integer>statuses = new ArrayList();
            if("1".equals(status)){
                statuses.add(FaeInvestRecord.InvestRecordStatus.notRepay.getStatus());
                statuses.add(FaeInvestRecord.InvestRecordStatus.repaying.getStatus());
            }else{
                statuses.add(FaeInvestRecord.InvestRecordStatus.repayed.getStatus());
            }
            paramMap.put("statuses", statuses);
        }

        // int count = faeInvestRecordService.queryFaeInvestRecordCountByParam(paramMap);

        Map countMap = faeInvestRecordService.queryFaeInvestRecordCountMapByParam(paramMap);

        int count = StringUtil.parseInt(countMap.get("count") + "" ,-1);

        BigDecimal totalInvestAmount = BigDecimal.ZERO;
        if(countMap.get("totalInvest") != null){
            totalInvestAmount = new BigDecimal(countMap.get("totalInvest") + "");
        }
        List<FaeInvestRecordVo> recordVos = null;
        if (count > 0) {
            recordVos = faeInvestRecordService.queryFaeInvestRecordByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != recordVos && recordVos.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeInvestRecordVo record : recordVos) {
                Map<String, Object> resultMap = new HashMap<>();

                String recordIdStr = IDEncryptor.getInstance().encryptWithoutException(record.getId());


                resultMap.put("productName",record.getProductName()+record.getPhase()+"期");
                resultMap.put("expectRate",record.getExpectRate());
                resultMap.put("incomeTerm",record.getIncomeTerm());
                resultMap.put("investAmount",FormatUtil.formatCurrency(record.getInvestAmount()));
                if(record.getInvestorType() == FaeInvestor.FaeInvestorType.personInvestor.getType()){
                    resultMap.put("investName",record.getRealName());
                    resultMap.put("certNo",record.getIdCardNo());
                }else{
                    resultMap.put("investName",record.getCompanyName());
                    resultMap.put("certNo",record.getCreditCode());
                }
                resultMap.put("investTime",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(record.getInvestTime()));
                resultMap.put("establishDate",DateUtil.formatDate(record.getEstablishDate(),"yyyy-MM-dd"));
                resultMap.put("dueDate",DateUtil.formatDate(record.getDueDate(),"yyyy-MM-dd"));

                List<Action> actions = new ArrayList<Action>();

                String op = "";
                if(record.getStatus() != FaeInvestRecord.InvestRecordStatus.repayed.getStatus()){
                    op = "回款计划";
                }else{
                    op = "回款记录";
                }
                Action detailAction =  ActionFactory.build(op,"",ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT,"asdf?id=" + recordIdStr,ActionFactory.REQ_TYPE_DIV,"repayPhaseDetail");

                actions.add(detailAction);

                Action contractAction =  ActionFactory.build("合同","");

                actions.add(contractAction);
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
            }

            Map<String, Object> data = new HashMap<>();
            data.put("totalRows", count);
            data.put("nav", "");
            data.put("content", listResultMap);
            retMap.put("data", data);

            Map totalHeader = new HashMap();
            totalHeader.put("total", count);
            totalHeader.put("totalInvestAmount", FormatUtil.formatCurrency(totalInvestAmount));
            data.put("totalHeader", totalHeader);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

}

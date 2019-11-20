package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.FaeInvestor;
import com.caishen91.jupiter.model.FaeInvestorRepayPhase;
import com.caishen91.jupiter.model.FaeRepayInfo;
import com.caishen91.jupiter.service.IFaeInvestRecordService;
import com.caishen91.jupiter.service.IFaeRepayInfoService;
import com.caishen91.jupiter.service.IFaeRepayPhaseService;
import com.caishen91.jupiter.util.*;
import com.caishen91.jupiter.util.excelutil.ExcelUtil;
import com.caishen91.jupiter.vo.FaeInvestorRepayPhaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 24
 * Description:
 */
@Controller
@RequestMapping("/manager/repayPhase")
public class FaeInvestorRepayPhaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeRepayPhaseService faeRepayPhaseService;

    @Autowired
    private IFaeRepayInfoService faeRepayInfoService;

    @Autowired
    private IFaeInvestRecordService faeInvestRecordService;

    @RequestMapping("/repayPhaseByRepayInfo")
    public String repayPhaseByRepayInfo(){
        String id = request.getParameter("id");

        int repayInfoId = IDEncryptor.getInstance().decryptWithoutException(id);
        FaeRepayInfo repayInfo = faeRepayInfoService.getRepayInfoById(repayInfoId);
        request.setAttribute("repayInfo",repayInfo);
        return "/manager/product/repayPhaseByRepayInfo";
    }


    @RequestMapping("/queryRepayPhaseByRecordId")
    @ResponseBody
    public Map<String,Object> queryRepayPhaseByRecordId(@RequestParam("recordId") String recordId){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        int id = IDEncryptor.getInstance().decryptWithoutException(recordId);
        List<FaeInvestorRepayPhase> repayPhases = faeRepayPhaseService.getRepayPhaseByInvestRecordId(id);

        List<Map>data = new ArrayList<>();

        for(FaeInvestorRepayPhase repayPhase : repayPhases){
            Map m = new HashMap();
            if(repayPhase.isBack()){
                m.put("repayDate",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(repayPhase.getActualRepayTime()));
            }else{
                m.put("repayDate",DateUtil.formatDate(repayPhase.getRepayDate(),"yyyy-MM-dd"));
            }

            m.put("repayPrincipal",FormatUtil.formatCurrency(repayPhase.getRepayPrincipal()));
            m.put("repayInterest",FormatUtil.formatCurrency(repayPhase.getRepayInterest()));
            m.put("totalRepay",FormatUtil.formatCurrency(repayPhase.getRepayPrincipal().add(repayPhase.getRepayInterest())));
            m.put("repayStatus",repayPhase.isBack()? "已还":"未还");
            data.add(m);

        }

        retMap.put("data", data);
        return retMap;
    }

    @RequestMapping("/queryRepayPhase")
    @ResponseBody
    public Map<String,Object> queryRepayPhase(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String repayInfoId
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

        if(StringUtil.isNotEmpty(repayInfoId)){
            int id = IDEncryptor.getInstance().decryptWithoutException(repayInfoId);
            paramMap.put("repayInfoId", id);
        }


        Map countMap = faeRepayPhaseService.queryFaeRepayPhaseCountMapByParam(paramMap);
        int count = StringUtil.parseInt(countMap.get("count") + "",-1);

        BigDecimal repayPrincipal = BigDecimal.ZERO;
        if(countMap.get("repayPrincipal") != null){
            repayPrincipal = StringUtil.parseDecimal(countMap.get("repayPrincipal") + "",DecimalUtil.Minus1);
        }
        BigDecimal repayInterest = BigDecimal.ZERO;
        if(countMap.get("repayInterest") != null){
            repayInterest = StringUtil.parseDecimal(countMap.get("repayInterest") + "",DecimalUtil.Minus1);
        }

        // int count = faeRepayPhaseService.queryFaeRepayPhaseCountByParam(paramMap);
        List<FaeInvestorRepayPhaseVo> feis = null;
        if (count > 0) {
            feis = faeRepayPhaseService.queryFaeRepayPhaseByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != feis && feis.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeInvestorRepayPhaseVo fei : feis) {
                Map<String, Object> resultMap = new HashMap<>();


                resultMap.put("num",fei.getNum());
                if(fei.getUserType() == FaeInvestor.FaeInvestorType.personInvestor.getType()){
                    resultMap.put("investorName",fei.getRealName());
                    resultMap.put("certNo",fei.getIdCardNo());
                }else {
                    resultMap.put("investorName",fei.getRealName());
                    resultMap.put("certNo",fei.getCreditCode());
                }

                resultMap.put("repayPrincipal",FormatUtil.formatCurrency(fei.getRepayPrincipal()));
                resultMap.put("repayInterest",FormatUtil.formatCurrency(fei.getRepayInterest()));

                resultMap.put("totalRepay",FormatUtil.formatCurrency(fei.getRepayInterest().add(fei.getRepayPrincipal())));

                resultMap.put("bankCode",fei.getBankCode());



                resultMap.put("bankName",fei.getBankName() + fei.getSlaveName());


                listResultMap.add(resultMap);
            }

            Map<String, Object> data = new HashMap<>();
            data.put("totalRows", count);
            data.put("nav", "");
            data.put("content", listResultMap);

            Map totalHeader = new HashMap();
            totalHeader.put("repayPrincipal", FormatUtil.formatCurrency(repayPrincipal));
            totalHeader.put("repayInterest", FormatUtil.formatCurrency(repayInterest));
            totalHeader.put("totalRepay", FormatUtil.formatCurrency(repayPrincipal.add(repayInterest)));
            data.put("totalHeader", totalHeader);

            retMap.put("data", data);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

    @RequestMapping("/queryRepayPhaseExport")
    public void queryRepayPhaseExport(@RequestParam(value = "repayInfoId", required = true) String repayInfoId,
                                      HttpServletResponse response) {
        Map<String, Object> paramMap = new HashMap();
        if (StringUtil.isNotEmpty(repayInfoId)) {
            paramMap.put("repayInfoId", IDEncryptor.getInstance().decryptWithoutException(repayInfoId));
        }

        Map countMap = faeRepayPhaseService.queryFaeRepayPhaseCountMapByParam(paramMap);
        int count = StringUtil.parseInt(countMap.get("count") + "", -1);

        BigDecimal repayPrincipal = StringUtil.parseDecimal(countMap.get("repayPrincipal") + "", DecimalUtil.Minus1);
        BigDecimal repayInterest = StringUtil.parseDecimal(countMap.get("repayInterest") + "", DecimalUtil.Minus1);

        List<FaeInvestorRepayPhaseVo> feis = null;
        if (count > 0) {
            int pageSize = 1000;
            paramMap.put("pageSize", pageSize);
            int totalPage = count / pageSize;
            if (count % pageSize > 0) {
                totalPage += 1;
            }

            for (int p = 1; p <= totalPage; p++) {
                int offset = (p - 1) / pageSize;
                paramMap.put("offset", offset);
                feis = faeRepayPhaseService.queryFaeRepayPhaseByParam(paramMap);
                exprotExcel(feis, repayPrincipal, repayInterest, response);
            }
        }
    }

    private void exprotExcel(List<FaeInvestorRepayPhaseVo> feis, BigDecimal repayPrincipal, BigDecimal repayInterest, HttpServletResponse response) {
        if (null != feis && feis.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            String fileName = "产品回款详细";
            String[] titles = new String[]{"序号", "投资人姓名", "应回本金(元)", "应回利息(元)", "应回金额(元)", "投资身份证号", "投资人银行卡号", "投资人开户行"};
            String headText = "应还本金(元)" + FormatUtil.formatCurrency(repayPrincipal) +
                    "应还利息(元)" +  FormatUtil.formatCurrency(repayInterest) +
                    "应还总额(元)" + FormatUtil.formatCurrency(repayPrincipal.add(repayInterest));
            for (FaeInvestorRepayPhaseVo fei : feis) {
                try {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("col1", String.valueOf(fei.getNum()));
                    if (fei.getUserType() == FaeInvestor.FaeInvestorType.personInvestor.getType()) {
                        resultMap.put("col2", fei.getRealName());
                        resultMap.put("col6", fei.getIdCardNo());
                    } else {
                        resultMap.put("col2", fei.getRealName());
                        resultMap.put("col6", fei.getCreditCode());
                    }
                    resultMap.put("col3", FormatUtil.formatCurrency(fei.getRepayPrincipal()));
                    resultMap.put("col4", FormatUtil.formatCurrency(fei.getRepayInterest()));
                    resultMap.put("col5", FormatUtil.formatCurrency(fei.getRepayInterest().add(fei.getRepayPrincipal())));
                    resultMap.put("col7", fei.getBankCode());
                    resultMap.put("col8", fei.getBankName() + fei.getSlaveName());
                    listResultMap.add(resultMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ExcelUtil.exportList(response, fileName, listResultMap, headText, titles);
        }
    }

}

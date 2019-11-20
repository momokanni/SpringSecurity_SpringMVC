package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.FaeProductStatus;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.service.*;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: jgn
 * @Date: 3/14/19 18 00
 * Description:
 */

@Controller
@RequestMapping("/manager/product")
public class ProductController {

    @Autowired
    private HttpServletRequest request;


    @Autowired
    private IFaeProductService faeProductService;

    @Autowired
    private IFaeIssueService faeIssueService;

    @Autowired
    private IFaeUnderwriterService faeUnderwriterService;

    @Autowired
    private IFaeDanbaoService faeDanbaoService;

    @Autowired
    private IFaeEntrustedService faeEntrustedService;

    @RequestMapping("/repayInfo")
    public String repayInfo() {
        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        FaeProduct product = faeProductService.getFaeProductById(id);
        request.setAttribute("product",product);
        return "/manager/product/repayInfo";
    }


    @RequestMapping("/investRecord")
    public String investRecord() {
        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        FaeProduct product = faeProductService.getFaeProductById(id);
        request.setAttribute("product",product);
        return "/manager/product/investRecord";
    }

    @RequestMapping("/establishInfo")
    public String establishInfo() {
        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        FaeProduct product = faeProductService.getFaeProductById(id);
        request.setAttribute("product",product);
        return "/manager/product/establishInfo";
    }


    @RequestMapping("/productDetail")
    public String productDetail() {
        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        FaeProduct product = faeProductService.getFaeProductById(id);

        if(product.getIssueId() > 0){
            FaeIssue issue = faeIssueService.getFaeIssueById(product.getIssueId());
            request.setAttribute("issue",issue);
        }

        if(product.getUnderwriterId() > 0){
            FaeUnderwriter underwriter = faeUnderwriterService.getFaeUnderwriterById(product.getUnderwriterId());
            request.setAttribute("underwriter",underwriter);
        }

        if(product.getDanbaoId() > 0){
            FaeDanbao danbao = faeDanbaoService.getFaeDanbaoById(product.getDanbaoId());
            request.setAttribute("danbao",danbao);
        }

        if(product.getEntrustedId() > 0){
            FaeEntrusted entrusted = faeEntrustedService.getFaeEntrustedById(product.getEntrustedId());
            request.setAttribute("entrusted",entrusted);
        }

        request.setAttribute("product",product);

        return "/manager/product/productDetail";

    }

    private Map<String,Object> getVoMap(Map<String,Object> fp) {
        Map<String, Object> map = new HashMap<String, Object>();

        int id = StringUtil.parseInt(fp.get("id") + "",-1);
        String sId = IDEncryptor.getInstance().encryptWithoutException(id);
        map.put("sid", sId);

        map.put("productName",StringUtil.setValueWhenNull(fp.get("productName") + ""));

        int productType = StringUtil.parseInt(fp.get("productType") + "",-1);
        map.put("productType",FaeProduct.ProductType.getProductType(productType).getDesc());


        map.put("issueName",StringUtil.setValueWhenNull(fp.get("issueName") + ""));

        BigDecimal raiseAmount = StringUtil.parseDecimal(fp.get("raiseAmount") + "",DecimalUtil.Minus1);
        map.put("raiseAmount",raiseAmount.doubleValue() > 0 ?  FormatUtil.formatCurrency(raiseAmount.divide(DecimalUtil.TenThousand.setScale(2,BigDecimal.ROUND_HALF_EVEN))) : "");
        map.put("expectRate",StringUtil.parseDecimal(fp.get("expectRate") + "",DecimalUtil.Minus1).doubleValue() > 0 ? fp.get("expectRate") : "");


        int term = StringUtil.parseInt(fp.get("term") + "",-1);
        map.put("term",term > 0 ? term : "");
        int termUnit = StringUtil.parseInt(fp.get("termUnit") + "",-1);
        map.put("termUnit",FaeProduct.Unit.getUnitByUint(termUnit).getDesc());

        map.put("createTime",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(DateUtil.parseDate(fp.get("createTime")+ "","yyyy-MM-dd HH:mm:ss")));

        map.put("statusName",FaeProductStatus.getFaeProductStatusByStatus(StringUtil.parseInt(fp.get("productStatus")+"",-1)).getDesc());

        List<Action> actions = new ArrayList<Action>();


        Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/product/productDetail?id=" + sId,ActionFactory.TARGET_SELF,
                ActionFactory.OPTYPE_LINK,"",ActionFactory.REQ_TYPE_LINK,"");

        actions.add(detailAction);


        map.put("opList", actions);

        return map;
    }


    @RequestMapping("/queryFaeProductList")
    @ResponseBody
    public Map<String,Object> queryFaeProductList(){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }
        List<Map<String,Object>> retDatas = new ArrayList<Map<String,Object>>();
        Map<String,Object> queryMap = new HashMap<String,Object>();

        int total = 0;
        String perPageNo = request.getParameter("perPageNo");
        String pageNo = request.getParameter("pageNo");
        try {
            int perPage_no = Integer.parseInt(perPageNo);
            int page_no = Integer.parseInt(pageNo);
            int offset = (page_no - 1) * perPage_no;
            queryMap.put("pageCount", perPage_no);
            queryMap.put("offset", offset);
        } catch (Exception e1) {
            e1.printStackTrace();
            queryMap.put("pageCount", 10);
            queryMap.put("offset", 0);
        }

        List<Integer> productStatuses = new ArrayList();
        String flag = request.getParameter("flag");
        if(StringUtil.isNotEmpty(flag)){
            if("repaying".equals(flag)){
                productStatuses.add(FaeProductStatus.full.getStatus());
            }

        }
        if(productStatuses.size() > 0){
            queryMap.put("productStatus",productStatuses);
        }

        String productName = request.getParameter("productName");
        if(StringUtil.isNotEmpty(productName)){
            queryMap.put("productName",productName);
        }

        String productTypeStr = request.getParameter("productType");
        if(StringUtil.isNotEmpty(productTypeStr)){
            int productType = StringUtil.parseInt(productTypeStr, -1);
            queryMap.put("productType",productType);
        }

        //起始时间
        String sDate = request.getParameter("sDate");
        Date startTime = null;
        if(StringUtil.isNotEmpty(sDate)){
            startTime = DateUtil.parseDate(sDate, "yyyy-MM-dd");
            queryMap.put("startTime", startTime);
        }

        //结束时间
        String eDate = request.getParameter("eDate");
        Date endTime = null;
        if(StringUtil.isNotEmpty(eDate)){
            endTime = DateUtil.parseDate(eDate, "yyyy-MM-dd");
            queryMap.put("endTime", endTime);
        }


        List<Map<String,Object>> productList = null;

        total = faeProductService.queryCountFaeProductByParam(queryMap);
        if(total > 0){
            productList = faeProductService.queryFaeProductMapByParam(queryMap);
        }

        if(productList != null && productList.size() >0){

            for(int i = 0; i < productList.size(); i++){
                Map<String,Object> fp = productList.get(i);
                Map<String, Object> map = getVoMap(fp);
                retDatas.add(map);
            }

        }


        Map<String,Object> data = new HashMap<String,Object>();
        data.put("totalRows", total);
        data.put("nav", "");
        data.put("content", retDatas);
        retMap.put("data", data);

        return retMap;
    }

    @RequestMapping("/allProduct")
    public String allProduct(){
        return "/manager/product/allProduct";
    }

    @RequestMapping("/repayingProduct")
    public String repayingProduct(){
        return "/manager/product/repayingProduct";
    }


    @RequestMapping("/addProduct")
    public String addProduct(){
        return "/manager/product/addProduct";
    }


    @RequestMapping("/motifyProduct")
    @ResponseBody
    public Map<String,Object> motifyProduct(){
        Map<String,Object> retMap = new HashMap<String,Object>();{
            retMap.put(Config.RET, Config.RET_OK);
        }

        OperationResult result = parseProduct();
        if(!result.isSuccess()){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, result.getMessage());
            return retMap;
        }
        FaeProduct product = (FaeProduct)result.getOther();
        boolean b = faeProductService.saveProduct(product);
        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作异常");
            return retMap;
        }

        return retMap;
    }

    private OperationResult parseProduct() {
        OperationResult or = new OperationResult();
        or.setStatus(true);

        FaeProduct product = new FaeProduct();

        String productTypeStr = request.getParameter("productType");
        int productType = StringUtil.parseInt(productTypeStr, -1);
        product.setProductType(productType);

        String productName = request.getParameter("productName");
        if(StringUtil.isEmpty(productName)){
            or.setStatus(false);
            or.setMessage("请输入产品名称");
            return or;
        }
        product.setProductName(productName);


        String issueIdStr = request.getParameter("issueId");
        if(StringUtil.isEmpty(issueIdStr)){
            or.setStatus(false);
            or.setMessage("请输入发行方");
            return or;
        }
        int issueId = IDEncryptor.getInstance().decryptWithoutException(issueIdStr);
        product.setIssueId(issueId);

        String underwriterIdStr = request.getParameter("underwriterId");
        if(StringUtil.isEmpty(underwriterIdStr)){
            or.setStatus(false);
            or.setMessage("请输入承销商");
            return or;
        }
        int underwriterId = IDEncryptor.getInstance().decryptWithoutException(underwriterIdStr);
        product.setUnderwriterId(underwriterId);

        String danbaoIdStr = request.getParameter("danbaoId");
        if(StringUtil.isEmpty(danbaoIdStr)){
            or.setStatus(false);
            or.setMessage("请输入担保方");
            return or;
        }
        int danbaoId = IDEncryptor.getInstance().decryptWithoutException(danbaoIdStr);
        product.setDanbaoId(danbaoId);

        String entrustedIdStr = request.getParameter("entrustedId");
        if(StringUtil.isEmpty(entrustedIdStr)){
            or.setStatus(false);
            or.setMessage("请输入受托管理人");
            return or;
        }
        int entrustedId = IDEncryptor.getInstance().decryptWithoutException(entrustedIdStr);
        product.setEntrustedId(entrustedId);


        String raiseAmountStr = request.getParameter("raiseAmount");
        if(StringUtil.isNotEmpty(raiseAmountStr)){
            BigDecimal raiseAmount = StringUtil.parseDecimal(raiseAmountStr,DecimalUtil.Minus1);
            if(raiseAmount.doubleValue() < 0){
                or.setStatus(false);
                or.setMessage("募集规模格式错误");
                return or;
            }
            raiseAmount = raiseAmount.multiply(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            product.setRaiseAmount(raiseAmount);
        }else{
            or.setStatus(false);
            or.setMessage("请输入募集规模");
            return or;
        }

        String termStr = request.getParameter("term");
        if(StringUtil.isNotEmpty(termStr)){
            int term = StringUtil.parseInt(termStr,-1);
            if(term < 0){
                or.setStatus(false);
                or.setMessage("产品期限格式错误");
                return or;
            }
            product.setTerm(term);
        }else{
            or.setStatus(false);
            or.setMessage("请输入产品期限");
            return or;
        }

        String termUnitStr = request.getParameter("termUnit");
        int termUnit = StringUtil.parseInt(termUnitStr, -1);
        product.setTermUnit(termUnit);



        String expectRateStr = request.getParameter("expectRate");
        if(StringUtil.isNotEmpty(expectRateStr)){
            BigDecimal expectRate = StringUtil.parseDecimal(expectRateStr,DecimalUtil.Minus1);
            if(expectRate.doubleValue() < 0){
                or.setStatus(false);
                or.setMessage("预期收益费率格式错误");
                return or;
            }
            product.setExpectRate(expectRate);
        }else{
            or.setStatus(false);
            or.setMessage("请输入预期收益费率");
            return or;
        }


        String baseAmountStr = request.getParameter("baseAmount");
        if(StringUtil.isNotEmpty(baseAmountStr)){
            BigDecimal baseAmount = StringUtil.parseDecimal(baseAmountStr,DecimalUtil.Minus1);
            if(baseAmount.doubleValue() < 0){
                or.setStatus(false);
                or.setMessage("认购基数格式错误");
                return or;
            }
            baseAmount = baseAmount.multiply(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            product.setBaseAmount(baseAmount);
        }else{
            or.setStatus(false);
            or.setMessage("请输入认购基数");
            return or;
        }

        String increaseAmountStr = request.getParameter("increaseAmount");
        if(StringUtil.isNotEmpty(increaseAmountStr)){
            BigDecimal increaseAmount = StringUtil.parseDecimal(increaseAmountStr,DecimalUtil.Minus1);
            if(increaseAmount.doubleValue() < 0){
                or.setStatus(false);
                or.setMessage("递增基数格式错误");
                return or;
            }
            increaseAmount = increaseAmount.multiply(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            product.setIncreaseAmount(increaseAmount);
        }else{
            or.setStatus(false);
            or.setMessage("请输入递增基数");
            return or;
        }
        String buyTypeStr = request.getParameter("buyType");
        int buyType = StringUtil.parseInt(buyTypeStr, -1);
        product.setBuyType(buyType);


        String holdCalTypeStr = request.getParameter("holdCalType");
        int holdCalType = StringUtil.parseInt(holdCalTypeStr, -1);
        product.setHoldCalType(holdCalType);
        
        if(holdCalType == FaeProduct.HoldCalType.decrement.getType()){
            String enDateStr = request.getParameter("enDate");
            if(StringUtil.isNotEmpty(enDateStr)){
                Date enDate = DateUtil.parseDate(enDateStr, "yyyy-MM-dd");
                product.setEndDate(enDate);
            }else{
                or.setStatus(false);
                or.setMessage("请选择截止日");
                return or;
            }
        }

        String dueDateStr = request.getParameter("dueDate");
        if(StringUtil.isNotEmpty(dueDateStr)){
            Date dueDate = DateUtil.parseDate(dueDateStr, "yyyy-MM-dd");
            product.setDueDate(dueDate);
        }/*else{
            or.setStatus(false);
            or.setMessage("请选择到期日");
            return or;
        }*/

        String transStr = request.getParameter("trans");
        boolean trans = StringUtil.parseInt(transStr, -1) == 1;
        product.setTrans(trans);
        
        if(trans){
            String lockTermStr = request.getParameter("lockTerm");
            if(StringUtil.isNotEmpty(lockTermStr)){
                int lockTerm = StringUtil.parseInt(lockTermStr,-1);
                if(lockTerm < 0){
                    or.setStatus(false);
                    or.setMessage("锁定期格式错误");
                    return or;
                }
                product.setLockTerm(lockTerm);
            }else{
                or.setStatus(false);
                or.setMessage("请输入锁定期");
                return or;
            }

            String lockUnitStr = request.getParameter("lockUnit");
            int lockUnit = StringUtil.parseInt(lockUnitStr, -1);
            product.setLockUnit(lockUnit);
        }

        String minEstablishAmountStr = request.getParameter("minEstablishAmount");
        if(StringUtil.isNotEmpty(minEstablishAmountStr)){
             BigDecimal minEstablishAmount = StringUtil.parseDecimal(minEstablishAmountStr,DecimalUtil.Minus1);
            if(minEstablishAmount.doubleValue() < 0){
                or.setStatus(false);
                or.setMessage("最低成立金额格式错误");
                return or;
            }
            minEstablishAmount = minEstablishAmount.multiply(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            product.setMinEstablishAmount(minEstablishAmount);

        }

        String establishTypeStr = request.getParameter("establishType");
        int establishType = StringUtil.parseInt(establishTypeStr, -1);
        product.setEstablishType(establishType);
        
        if(establishType == FaeProduct.EstablishType.auto.getType()){
            String establishDays = request.getParameter("establishDays");
            if(StringUtil.isNotEmpty(establishDays)){
                product.setEstablishDay(establishDays);
            }else{
                or.setStatus(false);
                or.setMessage("请输入自动成立时间");
                return or;
            }
        }

        String yearCalTypeStr = request.getParameter("yearCalType");
        int yearCalType = StringUtil.parseInt(yearCalTypeStr, -1);
        product.setYearCalType(yearCalType);


        String settlementTypeStr = request.getParameter("settlementType");
        int settlementType = StringUtil.parseInt(settlementTypeStr, -1);
        product.setSettlementType(settlementType);
        
        if(settlementType != FaeProduct.SettlementType.once.getType()){

            String fixedStr = request.getParameter("fixed");
            boolean fixed = StringUtil.parseInt(fixedStr, -1) == 1;
            product.setFixed(fixed);
            
            if(fixed){
                if(settlementType != FaeProduct.SettlementType.month.getType()) {
                    String fixedMonthStr = request.getParameter("fixedMonth");
                    int fixedMonth = StringUtil.parseInt(fixedMonthStr, -1);
                    product.setFixedMonth(fixedMonth);
                }

                String fixedDayStr = request.getParameter("fixedDay");
                if(StringUtil.isNotEmpty(fixedDayStr)){
                    int fixedDay = StringUtil.parseInt(fixedDayStr,-1);
                    if(fixedDay < 0){
                        or.setStatus(false);
                        or.setMessage("固定还息日格式错误");
                        return or;
                    }
                    product.setFixedDay(fixedDay);
                }else{
                    or.setStatus(false);
                    or.setMessage("请输入固定还息日");
                    return or;
                }
            }
            
        }

        String[] fees = request.getParameterValues("fees");
        boolean yizhi = false;
        if(fees != null && fees.length >= 2){
            String yizhiStr = request.getParameter("yizhi");
            yizhi = StringUtil.parseInt(yizhiStr, -1) == 1;
        }
        
        String yizhiMinFeeStr = request.getParameter("yizhiMinFee");
        String yizhiRateStr = request.getParameter("yizhiRate");
        String yizhiTypeStr = request.getParameter("yizhiType");
        String yueJieDayStr = request.getParameter("yueJieDay");



        if(fees != null && fees.length > 0){
            for(String fee : fees){

                if("0".equals(fee)){
                    product.setHasHang(true);
                    if(yizhi && fees.length >= 2){
                        //same
                        if(StringUtil.isNotEmpty(yizhiMinFeeStr)){
                            BigDecimal yizhiMinFee = StringUtil.parseDecimal(yizhiMinFeeStr,DecimalUtil.Minus1);
                            if(yizhiMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则最低额格式错误");
                                return or;
                            }else{
                                product.setHangMinFee(yizhiMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(yizhiRateStr)){
                            BigDecimal yizhiRate = StringUtil.parseDecimal(yizhiRateStr,DecimalUtil.Minus1);
                            if(yizhiRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则年化费率格式错误");
                                return or;
                            }
                            product.setHangRate(yizhiRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入收费规则年化费率");
                            return or;
                        }

                        int yizhiType = StringUtil.parseInt(yizhiTypeStr, -1);
                        product.setHangFeeType(yizhiType);

                        if(yizhiType == FaeProduct.FeeType.yj.getType()){
                            int yuejieDay = StringUtil.parseInt(yueJieDayStr,-1);
                            if(yuejieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确的月结日");
                                return or;
                            }
                            product.setHangYjDay(yuejieDay);
                        }

                    }else{
                        //self
                        String hangMinFeeStr = request.getParameter("hangMinFee");
                        String hangRateStr = request.getParameter("hangRate");
                        String hangFeeTypeStr = request.getParameter("hangFeeType");
                        String hangYueJieDayStr = request.getParameter("hangYueJieDay");


                        if(StringUtil.isNotEmpty(hangMinFeeStr)){
                            BigDecimal hangMinFee = StringUtil.parseDecimal(hangMinFeeStr,DecimalUtil.Minus1);
                            if(hangMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("挂牌费最低额格式错误");
                                return or;
                            }else{
                                product.setHangMinFee(hangMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(hangRateStr)){
                            BigDecimal hangRate = StringUtil.parseDecimal(hangRateStr,DecimalUtil.Minus1);
                            if(hangRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("挂牌费年化费率格式错误");
                                return or;
                            }
                            product.setHangRate(hangRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入挂牌费年化费率");
                            return or;
                        }

                        int hangFeeType = StringUtil.parseInt(hangFeeTypeStr, -1);
                        product.setHangFeeType(hangFeeType);

                        if(hangFeeType == FaeProduct.FeeType.yj.getType()){
                            int hangYueJieDay = StringUtil.parseInt(hangYueJieDayStr,-1);
                            if(hangYueJieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确的挂牌费月结日");
                                return or;
                            }
                            product.setHangYjDay(hangYueJieDay);
                        }


                    }

                }
                if("1".equals(fee)){
                    product.setHasCx(true);
                    if(yizhi && fees.length >= 2){
                        //same
                        if(StringUtil.isNotEmpty(yizhiMinFeeStr)){
                            BigDecimal yizhiMinFee = StringUtil.parseDecimal(yizhiMinFeeStr,DecimalUtil.Minus1);
                            if(yizhiMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则最低额格式错误");
                                return or;
                            }else{
                                product.setCxMinFee(yizhiMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(yizhiRateStr)){
                            BigDecimal yizhiRate = StringUtil.parseDecimal(yizhiRateStr,DecimalUtil.Minus1);
                            if(yizhiRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则年化费率格式错误");
                                return or;
                            }
                            product.setCxRate(yizhiRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入收费规则年化费率");
                            return or;
                        }

                        int yizhiType = StringUtil.parseInt(yizhiTypeStr, -1);
                        product.setCxFeeType(yizhiType);

                        if(yizhiType == FaeProduct.FeeType.yj.getType()){
                            int yuejieDay = StringUtil.parseInt(yueJieDayStr,-1);
                            if(yuejieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确的月结日");
                                return or;
                            }
                            product.setCxYjDay(yuejieDay);
                        }
                    }else{
                        //self
                        String cxMinFeeStr = request.getParameter("cxMinFee");
                        String cxRateStr = request.getParameter("cxRate");
                        String cxFeeTypeStr = request.getParameter("cxFeeType");
                        String cxYueJieDayStr = request.getParameter("cxYueJieDay");

                        if(StringUtil.isNotEmpty(cxMinFeeStr)){
                            BigDecimal cxMinFee = StringUtil.parseDecimal(cxMinFeeStr,DecimalUtil.Minus1);
                            if(cxMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("承销商费最低额格式错误");
                                return or;
                            }else{
                                product.setCxMinFee(cxMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(cxRateStr)){
                            BigDecimal cxRate = StringUtil.parseDecimal(cxRateStr,DecimalUtil.Minus1);
                            if(cxRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("承销商费年化费率格式错误");
                                return or;
                            }
                            product.setCxRate(cxRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入承销商费年化费率");
                            return or;
                        }

                        int cxFeeType = StringUtil.parseInt(cxFeeTypeStr, -1);
                        product.setCxFeeType(cxFeeType);

                        if(cxFeeType == FaeProduct.FeeType.yj.getType()){
                            int cxYueJieDay = StringUtil.parseInt(cxYueJieDayStr,-1);
                            if(cxYueJieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确的承销商费月结日");
                                return or;
                            }
                            product.setCxYjDay(cxYueJieDay);
                        }
                    }
                }
                if("2".equals(fee)){
                    product.setHasSt(true);
                    if(yizhi && fees.length >= 2){
                        //same
                        if(StringUtil.isNotEmpty(yizhiMinFeeStr)){
                            BigDecimal yizhiMinFee = StringUtil.parseDecimal(yizhiMinFeeStr,DecimalUtil.Minus1);
                            if(yizhiMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则最低额格式错误");
                                return or;
                            }else{
                                product.setStMinFee(yizhiMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(yizhiRateStr)){
                            BigDecimal yizhiRate = StringUtil.parseDecimal(yizhiRateStr,DecimalUtil.Minus1);
                            if(yizhiRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("收费规则年化费率格式错误");
                                return or;
                            }
                            product.setStRate(yizhiRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入收费规则年化费率");
                            return or;
                        }

                        int yizhiType = StringUtil.parseInt(yizhiTypeStr, -1);
                        product.setStFeeType(yizhiType);
                        if(yizhiType == FaeProduct.FeeType.yj.getType()){
                            int yuejieDay = StringUtil.parseInt(yueJieDayStr,-1);
                            if(yuejieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确月结日");
                                return or;
                            }
                            product.setStYjDay(yuejieDay);
                        }
                    }else{
                        //self
                        String stMinFeeStr = request.getParameter("stMinFee");
                        String stRateStr = request.getParameter("stRate");
                        String stFeeTypeStr = request.getParameter("stFeeType");
                        String stYueJieDayStr = request.getParameter("stYueJieDay");

                        if(StringUtil.isNotEmpty(stMinFeeStr)){
                            BigDecimal stMinFee = StringUtil.parseDecimal(stMinFeeStr,DecimalUtil.Minus1);
                            if(stMinFee.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("受托管理费最低额格式错误");
                                return or;
                            }else{
                                product.setStMinFee(stMinFee);
                            }
                        }

                        if(StringUtil.isNotEmpty(stRateStr)){
                            BigDecimal stRate = StringUtil.parseDecimal(stRateStr,DecimalUtil.Minus1);
                            if(stRate.doubleValue() < 0){
                                or.setStatus(false);
                                or.setMessage("受托管理费年化费率格式错误");
                                return or;
                            }
                            product.setStRate(stRate);

                        }else{
                            or.setStatus(false);
                            or.setMessage("请输入受托管理费年化费率格式");
                            return or;
                        }

                        int stFeeType = StringUtil.parseInt(stFeeTypeStr, -1);
                        product.setStFeeType(stFeeType);

                        if(stFeeType == FaeProduct.FeeType.yj.getType()){
                            int stYueJieDay = StringUtil.parseInt(stYueJieDayStr,-1);
                            if(stYueJieDay < 0){
                                or.setStatus(false);
                                or.setMessage("请输入正确的受托管理费月结日");
                                return or;
                            }
                            product.setStYjDay(stYueJieDay);
                        }
                    }
                }

            }
        }


        String amountUse = request.getParameter("amountUse");
        if(StringUtil.isEmpty(amountUse)){
            or.setStatus(false);
            or.setMessage("请输入资金用途");
            return or;
        }
        product.setAmountUse(amountUse);

        String increaseCredit = request.getParameter("increaseCredit");
        if(StringUtil.isEmpty(increaseCredit)){
            or.setStatus(false);
            or.setMessage("请输入增信措施");
            return or;
        }
        product.setIncreaseCredit(increaseCredit);

        String remark = request.getParameter("remark");
        if(StringUtil.isNotEmpty(remark)){
            product.setRemark(remark);
        }
        product.setCreateTime(new Date());

        or.setOther(product);
        return or;
    }
}

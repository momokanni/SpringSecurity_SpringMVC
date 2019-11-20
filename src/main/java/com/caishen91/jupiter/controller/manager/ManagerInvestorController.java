package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.service.*;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/manager/investor")
public class ManagerInvestorController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IFaeInvestorService faeInvestorService;

    @Autowired
    private IFaeBankCardService faeBankCardService;

    @Autowired
    private IFaeUnderwriterService faeUnderwriterService;

    @Autowired
    private IFaeUnderwriterInvestorService faeUnderwriterInvestorService;

    @Autowired
    private IFaeInvestorAccountService faeInvestorAccountService;

    @Autowired
    private IFaeInvestRecordService faeInvestRecordService;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        faeInvestorService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/investorRecord")
    public String investorRecord(){
        String investorIdStr = request.getParameter("id");
        int investorId = IDEncryptor.getInstance().decryptWithoutException(investorIdStr);
        FaeInvestor faeInvestor = faeInvestorService.getFaeInvestorById(investorId);
        request.setAttribute("faeInvestor", faeInvestor);

        return "/manager/member/faeInvestor/investorRecord";
    }


    @RequestMapping("/addFaeInvestor")
    @ResponseBody
    public Map<String,Object> addFaeInvestor(){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        String typeStr = request.getParameter("type");
        int type = Integer.parseInt(typeStr);
        FaeInvestor faeInvestor = new FaeInvestor();
        faeInvestor.setType(type);
        if (type == FaeInvestor.FaeInvestorType.personInvestor.getType()) {
            String realName = request.getParameter("realName");
            String idCardNo = request.getParameter("idCardNo");
            String mobile = request.getParameter("mobile");


            if (StringUtil.isEmpty(realName)) {
                retMap.put(Config.ERR_MSG, "真实姓名不能为空");
                return retMap;
            } else if (StringUtil.isEmpty(idCardNo)) {
                retMap.put(Config.ERR_MSG, "身份证号不能为空");
                return retMap;
            } else if (!ValidateUtil.isIDCard(idCardNo)) {
                retMap.put(Config.ERR_MSG, "身份证号格式错误");
                return retMap;
            } else if (StringUtil.isNotEmpty(mobile) && !ValidateUtil.isNumber(mobile)) {
                retMap.put(Config.ERR_MSG, "手机号格式错误");
                return retMap;
            } else {
                retMap.put(Config.RET, Config.RET_OK);
            }

            faeInvestor.setRealName(realName);
            faeInvestor.setIdCardNo(idCardNo);
            faeInvestor.setMobile(mobile);
        } else if (type == FaeInvestor.FaeInvestorType.companyInvestor.getType()) {
            String companyName = request.getParameter("companyName");
            String creditCode = request.getParameter("creditCode");
            String businessLicense = request.getParameter("businessLicense");
            String legalPersonName = request.getParameter("legalPersonName");
            String contacts = request.getParameter("contacts");
            String contactsTel = request.getParameter("contactsTel");

            if (StringUtil.isEmpty(companyName)) {
                retMap.put(Config.ERR_MSG, "公司名称不能为空");
                return retMap;
            } else if (StringUtil.isEmpty(creditCode)) {
                retMap.put(Config.ERR_MSG, "统一社会信用代码不能为空");
                return retMap;
            } else if (StringUtil.isEmpty(businessLicense)) {
                retMap.put(Config.ERR_MSG, "营业执照编号不能为空");
                return retMap;
            } else if (StringUtil.isEmpty(legalPersonName)) {
                retMap.put(Config.ERR_MSG, "法人姓名");
                return retMap;
            } else if (StringUtil.isEmpty(contacts)) {
                retMap.put(Config.ERR_MSG, "联系人不能为空");
                return retMap;
            } else if (StringUtil.isEmpty(contactsTel)) {
                retMap.put(Config.ERR_MSG, "联系人电话不能为空");
                return retMap;
            } else if (!ValidateUtil.isMobileNo(contactsTel)) {
                retMap.put(Config.ERR_MSG, "联系人电话格式错误");
                return retMap;
            } else {
                retMap.put(Config.RET, Config.RET_OK);
            }

            faeInvestor.setCompanyName(companyName);
            faeInvestor.setCreditCode(creditCode);
            faeInvestor.setBusinessLicense(businessLicense);
            faeInvestor.setLegalPersonName(legalPersonName);
            faeInvestor.setContacts(contacts);
            faeInvestor.setContactsTel(contactsTel);
        }

        String userSourceStr = request.getParameter("userSource");
        if (ValidateUtil.isNumber(userSourceStr)) {
            faeInvestor.setUserSource(Integer.parseInt(userSourceStr));
        }
        String referrerStr = request.getParameter("referrer");
        if (ValidateUtil.isNumber(referrerStr)) {
            faeInvestor.setReferrer(Integer.parseInt(referrerStr));
        }
        faeInvestor.setCreateTime(new Date());

        try {
            faeInvestorService.addFaeInvestor(faeInvestor);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toInvestorList")
    public String toInvestorList(){
        return "/manager/member/faeInvestor/faeInvestorList";
    }

    @RequestMapping("/queryFaeInvestorList")
    @ResponseBody
    public Map<String,Object> queryFaeInvestorList(
            @RequestParam(defaultValue = "0", required = false) String  pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String name, String idCardNo, String startTime, String endTime) {

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("name", name);
        paramMap.put("card", idCardNo);
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

        int count = faeInvestorService.queryFaeInvestorCountByParam(paramMap);
        List<FaeInvestor> faeInvestors = null;
        if (count > 0) {
            faeInvestors = faeInvestorService.queryFaeInvestorListByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != faeInvestors && faeInvestors.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (FaeInvestor faeInvestor : faeInvestors) {
                Map<String, Object> resultMap = new HashMap<>();

                String investorIdStr = IDEncryptor.getInstance().encryptWithoutException(faeInvestor.getId());
                resultMap.put("number", faeInvestor.getId());
                if (FaeInvestor.FaeInvestorType.personInvestor.getType() == faeInvestor.getType()) {
                    resultMap.put("name", faeInvestor.getRealName());
                    resultMap.put("code", StringUtil.maskIDCardNo(faeInvestor.getIdCardNo(), 3, 4));
                    resultMap.put("type", FaeInvestor.FaeInvestorType.getFaeInvestorType(faeInvestor.getType()).getDesc());
                } else if (FaeInvestor.FaeInvestorType.companyInvestor.getType() == faeInvestor.getType()) {
                    resultMap.put("name", faeInvestor.getCompanyName());
                    resultMap.put("code", StringUtil.maskIDCardNo(faeInvestor.getCreditCode(), 3, 4));
                    resultMap.put("type", FaeInvestor.FaeInvestorType.getFaeInvestorType(faeInvestor.getType()).getDesc());
                }

                List<FaeBankCard> faeBankCards = faeBankCardService.getFaeBankCardByInvestorId(faeInvestor.getId());
                StringBuilder builder = new StringBuilder();
                List<String> bankCards = new ArrayList<>();
                if (null != faeBankCards && faeBankCards.size() > 0) {
                    for (FaeBankCard faeBankCard : faeBankCards) {
                        builder.append(faeBankCard.getBankName() + "(");
                        if (faeBankCard.getBankCode().length() > 4) {
                            String bankCard = faeBankCard.getBankCode();
                            builder.append(bankCard.substring(bankCard.length() - 4, bankCard.length()));
                        } else {
                            builder.append(faeBankCard.getBankCode());
                        }
                        builder.append(")");
                        bankCards.add(builder.toString());
                        builder.delete(0, builder.length());
                    }
                    resultMap.put("bankAccount", bankCards);
                } else {
                    resultMap.put("bankAccount", bankCards);
                }

                List<FaeInvestRecord> faeInvestRecords = faeInvestRecordService.getFaeInvestRecordByInvestorId(faeInvestor.getId());
                if (null != faeInvestRecords && faeInvestRecords.size() > 0) {
                    BigDecimal investAmount = BigDecimal.ZERO;
                    for (FaeInvestRecord fir : faeInvestRecords) {
                        investAmount = investAmount.add(fir.getInvestAmount()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    }
                    resultMap.put("investAmount", investAmount.toPlainString());
                } else {
                    resultMap.put("investAmount", "---");
                }

                List<FaeUnderwriterInvestor> faeUnderwriterInvestors = faeUnderwriterInvestorService.getFaeUnderwriterInvestorByInvestorId(faeInvestor.getId());
                List<Integer> underwriterIds = new ArrayList<>();
                if (null != faeUnderwriterInvestors && faeUnderwriterInvestors.size() > 0) {
                    faeUnderwriterInvestors.forEach((faeUnderwriterInvestor) -> underwriterIds.add(faeUnderwriterInvestor.getUnderwriterId()));
                    List<FaeUnderwriter> faeUnderwriters = faeUnderwriterService.getFaeUnderwriterByIds(underwriterIds);
                    if (null != faeUnderwriters && faeUnderwriters.size() > 0) {
                        List<String> underwriterNames = new ArrayList<>();
                        faeUnderwriters.forEach((faeUnderwriter -> underwriterNames.add(faeUnderwriter.getShortName())));
                        resultMap.put("userSource", underwriterNames);
                    }
                } else {
                    resultMap.put("userSource", underwriterIds);
                }

                resultMap.put("registerTime", DateUtil.formatDate(faeInvestor.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));

                if (0 == faeInvestor.getReferrer()) {
                    resultMap.put("referrer", "---");
                } else {
                    resultMap.put("referrer", StringUtil.outputToJudge(faeInvestor.getReferrer()));
                }

                List<Action> actions = new ArrayList<Action>();
                Action detailAction =  ActionFactory.build(ActionFactory.CATEGORY_LOOK,"/manager/investor/getFaeInvestorDetailById?id=" + investorIdStr,ActionFactory.TARGET_SELF,
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

    @RequestMapping("getFaeInvestorDetailById")
    public String getFaeInvestorDetailById(@RequestParam(value = "id", required = false) String investorIdStr) {
        int investorId = IDEncryptor.getInstance().decryptWithoutException(investorIdStr);
        FaeInvestor faeInvestor = faeInvestorService.getFaeInvestorById(investorId);
        request.setAttribute("faeInvestor", faeInvestor);

        if (null != faeInvestor) {
            List<FaeBankCard> faeBankCards = faeBankCardService.getFaeBankCardByInvestorId(faeInvestor.getId());
            request.setAttribute("faeBankCards", faeBankCards);
            FaeInvestorAccount faeInvestorAccount = faeInvestorAccountService.getFaeInvestorAccountByInvestorId(faeInvestor.getId());
            request.setAttribute("faeInvestorAccount", faeInvestorAccount);
            List<FaeUnderwriterInvestor> faeUnderwriterInvestors = faeUnderwriterInvestorService.getFaeUnderwriterInvestorByInvestorId(faeInvestor.getId());
            if (null != faeUnderwriterInvestors && faeUnderwriterInvestors.size() > 0) {

                BigDecimal investAmount = BigDecimal.ZERO;
                investAmount = investAmount.add(faeInvestorAccount.getToCollectPrincipal()).add(faeInvestorAccount.getToCollectInterest()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                request.setAttribute("investAmount", investAmount);

                List<Integer> underwriterIds = new ArrayList<>();
                faeUnderwriterInvestors.forEach(faeUnderwriterInvestor -> underwriterIds.add(faeUnderwriterInvestor.getUnderwriterId()));
                List<FaeUnderwriter> faeUnderwriters = faeUnderwriterService.getFaeUnderwriterByIds(underwriterIds);
                List<String> underwriterNames = new ArrayList<>();
                if (null != faeUnderwriters && faeUnderwriters.size() > 0) {
                    faeUnderwriters.forEach(faeUnderwriter -> underwriterNames.add(faeUnderwriter.getShortName()));
                }
                request.setAttribute("underwriterNames", underwriterNames);
            }
        }

        String pageUrl = "";
        if (FaeInvestor.FaeInvestorType.personInvestor.getType() == faeInvestor.getType()) {
            pageUrl = "/manager/member/faeInvestor/personInvestorDetail";
        } else if (FaeInvestor.FaeInvestorType.companyInvestor.getType() == faeInvestor.getType()) {
            pageUrl = "/manager/member/faeInvestor/companyInvestorDetail";
        }

        return pageUrl;
    }
}

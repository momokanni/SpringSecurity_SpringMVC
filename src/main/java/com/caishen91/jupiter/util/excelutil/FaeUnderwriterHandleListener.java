package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.caishen91.jupiter.model.FaeUnderwriter;
import com.caishen91.jupiter.service.IFaeUnderwriterService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaeUnderwriterHandleListener extends ExcelHandleListener{

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        ArrayList<String> strList = baseHandle(analysisContext, obj);
        try {
            if (strList.size() >= 3 && 0 != analysisContext.getCurrentRowNum()) {
                genFaeEntrusted(strList);
                updateExcelHandle();
            }
        } catch (Exception e) {
            currentCount--;
            failNums++;
            e.printStackTrace();
        }
    }

    private void genFaeEntrusted(List<String> strList) {
        IFaeUnderwriterService faeUnderwriterService = (IFaeUnderwriterService) BeanFactoryUtil.getContext().getBean("faeUnderwriterServiceImpl");
        FaeUnderwriter faeUnderwriter = new FaeUnderwriter();
        FaeUnderwriter underwriter = faeUnderwriterService.getFaeUnderwriterByCreditCode(strList.get(2));
        if (null == underwriter) {
            faeUnderwriter.setName(strList.get(0));
            faeUnderwriter.setShortName(strList.get(1));
            faeUnderwriter.setCreditCode(strList.get(2));
            faeUnderwriter.setCreateTime(new Date());
            faeUnderwriterService.addFaeUnderwriter(faeUnderwriter);
        } else {
            currentCount--;
            repetitionNums++;
        }
    }

    public FaeUnderwriterHandleListener(int excelHandleId) {
        super(excelHandleId);
    }
}

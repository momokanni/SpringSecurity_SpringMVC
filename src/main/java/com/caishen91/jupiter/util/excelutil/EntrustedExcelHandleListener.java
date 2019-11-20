package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.caishen91.jupiter.model.FaeEntrusted;
import com.caishen91.jupiter.service.IFaeEntrustedService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntrustedExcelHandleListener extends ExcelHandleListener{

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
        IFaeEntrustedService faeEntrustedService = (IFaeEntrustedService) BeanFactoryUtil.getContext().getBean("faeEntrustedServiceImpl");
        FaeEntrusted faeEntrusted = new FaeEntrusted();
        FaeEntrusted entrusted = faeEntrustedService.getFaeEntrustedByCreditCode(strList.get(2));
        if (null == entrusted) {
            faeEntrusted.setName(strList.get(0));
            faeEntrusted.setShortName(strList.get(1));
            faeEntrusted.setCreditCode(strList.get(2));
            faeEntrusted.setCreateTime(new Date());
            faeEntrustedService.addFaeEntrusted(faeEntrusted);
        } else {
            currentCount--;
            repetitionNums++;
        }
    }

    public EntrustedExcelHandleListener(int excelHandleId) {
        super(excelHandleId);
    }
}

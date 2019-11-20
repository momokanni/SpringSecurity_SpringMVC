package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.caishen91.jupiter.model.FaeClique;
import com.caishen91.jupiter.service.IFaeICliqueService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CliqueExcelHandleListener extends ExcelHandleListener {

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        ArrayList<String> strList = baseHandle(analysisContext, obj);
        try {
            if (strList.size() >= 3 && 0 != analysisContext.getCurrentRowNum()) {
                genFaeClique(strList);
                updateExcelHandle();
            }
        } catch (Exception e) {
            currentCount--;
            failNums++;
            e.printStackTrace();
        }
    }

    private void genFaeClique(List<String> strList) {
        IFaeICliqueService faeICliqueService = (IFaeICliqueService) BeanFactoryUtil.getContext().getBean("faeCliqueServiceImpl");
        FaeClique faeClique = new FaeClique();
        FaeClique clique = faeICliqueService.getFaeCliqueByCreditCode(strList.get(2));
        if (null == clique) {
            faeClique.setName(strList.get(0));
            faeClique.setShortName(strList.get(1));
            faeClique.setCreditCode(strList.get(2));
            faeClique.setCreateTime(new Date());
            faeICliqueService.addFaeClique(faeClique);
        } else {
            currentCount--;
            repetitionNums++;
        }
    }

    public CliqueExcelHandleListener(int excelHandleId) {
        super(excelHandleId);
    }
}

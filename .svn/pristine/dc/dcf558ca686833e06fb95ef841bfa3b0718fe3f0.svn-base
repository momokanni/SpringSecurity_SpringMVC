package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.caishen91.jupiter.model.FaeIssue;
import com.caishen91.jupiter.service.IFaeIssueService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IssueExcelHandleListener extends ExcelHandleListener{

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        ArrayList<String> strList = baseHandle(analysisContext, obj);
        try {
            if (strList.size() >= 3 && 0 != analysisContext.getCurrentRowNum()) {
                genFaeIssue(strList);
                updateExcelHandle();
            }
        } catch (Exception e) {
            currentCount--;
            failNums++;
            e.printStackTrace();
        }
    }

    private void genFaeIssue(List<String> strList) {
        IFaeIssueService faeIssueService = (IFaeIssueService) BeanFactoryUtil.getContext().getBean("faeIssueServiceImpl");
        FaeIssue faeIssue = new FaeIssue();
        //TODO 这里缺少集团的Id
        FaeIssue issue = faeIssueService.getFaeIssueByCreditCode(strList.get(2));
        if (null == issue) {
            faeIssue.setName(strList.get(0));
            faeIssue.setShortName(strList.get(1));
            faeIssue.setCreditCode(strList.get(2));
            faeIssue.setCreateTime(new Date());
            faeIssueService.addFaeIssue(faeIssue);
        } else {
            currentCount--;
            repetitionNums++;
        }
    }

    public IssueExcelHandleListener(int excelHandleId) {
        super(excelHandleId);
    }
}

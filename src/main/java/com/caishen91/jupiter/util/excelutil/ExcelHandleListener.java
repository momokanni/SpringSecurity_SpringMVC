package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.caishen91.jupiter.model.ExcelHandle;
import com.caishen91.jupiter.service.IImportService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ExcelHandleListener extends AnalysisEventListener {

    private IImportService importService = (IImportService) BeanFactoryUtil.getContext().getBean("importServiceImpl");

    protected List<Object> datas = new ArrayList<Object>();
    protected int totlaCount;
    protected int currentCount;
    protected int sheetNums;
    protected int failNums;
    protected int repetitionNums;
    private int excelHandleId;


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        ExcelHandle excelHandle = importService.getExcelHandleById(excelHandleId);
        excelHandle.setStatus(ExcelHandle.ExcelHandleStatus.receiveSucc.getStatus());
        excelHandle.setEndTime(new Date());
        importService.updateExcelHandle(excelHandle);
    }

    protected ArrayList<String> baseHandle(AnalysisContext analysisContext, Object obj) {
        Sheet sheet = analysisContext.getCurrentSheet();
        if (sheetNums != sheet.getSheetNo()) {
            sheetNums = sheet.getSheetNo();
            if (totlaCount > 0) {
                totlaCount += analysisContext.getTotalCount();
            } else {
                totlaCount = analysisContext.getTotalCount();
            }
        }
        currentCount++;
        ArrayList<String> strList = (ArrayList<String>)obj;
        return strList;
    }



    protected void updateExcelHandle() {
        ExcelHandle excelHandle = importService.getExcelHandleById(excelHandleId);
        excelHandle.setExcelTotal(totlaCount);
        excelHandle.setHandleNums(currentCount);
        excelHandle.setFailNums(failNums);
        excelHandle.setRepetitionNums(repetitionNums);
        importService.updateExcelHandleNums(excelHandle);
    }

    public ExcelHandleListener(int excelHandleId) {
        this.excelHandleId = excelHandleId;
    }
}

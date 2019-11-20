package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.context.AnalysisContext;
import com.caishen91.jupiter.model.FaeDanbao;
import com.caishen91.jupiter.service.IFaeDanbaoService;
import com.caishen91.jupiter.util.BeanFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DanbaoExcelHandleListener extends ExcelHandleListener{

    @Override
    public void invoke(Object obj, AnalysisContext analysisContext) {
        ArrayList<String> strList = baseHandle(analysisContext, obj);
        try {
            if (strList.size() >= 3 && 0 != analysisContext.getCurrentRowNum()) {
                genFaeDanbao(strList);
                updateExcelHandle();
            }
        } catch (Exception e) {
            currentCount--;
            failNums++;
            e.printStackTrace();
        }
    }

    private void genFaeDanbao(List<String> strList) {
        IFaeDanbaoService faeDanbaoService = (IFaeDanbaoService) BeanFactoryUtil.getContext().getBean("faeDanbaoServiceImpl");
        FaeDanbao faeDanbao = new FaeDanbao();
        FaeDanbao danbao = faeDanbaoService.getFaeDanbaoByCreditCode(strList.get(2));
        if (null == danbao) {
            faeDanbao.setName(strList.get(0));
            faeDanbao.setShortName(strList.get(1));
            faeDanbao.setCreditCode(strList.get(2));
            faeDanbao.setCreateTime(new Date());
            faeDanbaoService.addFaeDanbao(faeDanbao);
        } else {
            currentCount--;
            repetitionNums++;
        }
    }

    public DanbaoExcelHandleListener(int excelHandleId) {
        super(excelHandleId);
    }
}

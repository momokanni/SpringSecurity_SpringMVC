package com.caishen91.jupiter.util.excelutil;

import com.alibaba.excel.ExcelReader;
import com.caishen91.jupiter.model.ExcelHandle;
import com.caishen91.jupiter.util.DateUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public static boolean readExcel(File file, String type, int excelHandleId) {
        ExcelHandleListener excelListener = null;
        boolean bo = true;

        if (ExcelHandle.ExcelHandleType.clique.getType().equals(type)) {
            excelListener = new CliqueExcelHandleListener(excelHandleId);
        } else if (ExcelHandle.ExcelHandleType.issue.getType().equals(type)) {
            excelListener = new IssueExcelHandleListener(excelHandleId);
        } else if (ExcelHandle.ExcelHandleType.danbao.getType().equals(type)) {
            excelListener = new DanbaoExcelHandleListener(excelHandleId);
        } else if (ExcelHandle.ExcelHandleType.entrusted.getType().equals(type)) {
            excelListener = new EntrustedExcelHandleListener(excelHandleId);
        } else if (ExcelHandle.ExcelHandleType.underwriter.getType().equals(type)) {
            excelListener = new FaeUnderwriterHandleListener(excelHandleId);
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            ExcelReader excelReader = new ExcelReader(inputStream, null, excelListener, true);
            excelReader.read();
        } catch (Exception e) {
            e.printStackTrace();
            bo = false;
            return bo;
        }

        return bo;
    }

    //创建HSSFWorkbook工作薄对象
    public static void exportList(HttpServletResponse response, String fileName, List<Map<String, Object>> mapList, String headText, String[] columnName){
        int len = columnName.length;

        //创建工作薄对象s
        HSSFWorkbook wb = new HSSFWorkbook();
        //首行信息
        HSSFCellStyle firstStyle = firstStyle(wb);
        //创建标题行样式
        HSSFCellStyle headStyle = headStyle(wb);
        //创建内容行样式
        HSSFCellStyle contentStyle = contentStyle(wb);
        //创建表
        HSSFSheet sheet_1 =  wb.createSheet("Sheet1");
        //设置表的默认列宽
        sheet_1.setDefaultColumnWidth((short) 30);

        HSSFRow firstRow = sheet_1.createRow(0);
        firstRow.setHeightInPoints(60);
        HSSFCell fcell = firstRow.createCell((short) 0);
        sheet_1.addMergedRegion(new Region(0, (short)0, 0, (short)(len - 1)));
        fcell.setCellValue(headText);
        fcell.setCellStyle(firstStyle);

        //创建标题行
        HSSFRow headRow = sheet_1.createRow(1);
        for (int i = 0; i < columnName.length; i++) {
            HSSFCell cell = headRow.createCell((short) i);
            cell.setCellValue(columnName[i]);
            cell.setCellStyle(headStyle);
        }

        //为内容行添加数据和样式
        for (int i = 1; i <= mapList.size(); i++) {
            HSSFRow contentRow = sheet_1.createRow(i+1);
            Map map = mapList.get(i-1);
            for (int j = 0; j < columnName.length; j++) {
                HSSFCell cell = contentRow.createCell((short) j);
                cell.setCellValue((String)map.get("col"+(j+1)));
                cell.setCellStyle(contentStyle);
            }
        }
        outPutContent(response,wb,fileName);
    }

    /**
     * 第一行
     */
    public static HSSFCellStyle firstStyle(HSSFWorkbook wb){
        HSSFCellStyle style = wb.createCellStyle();                       //创建样式对象
        HSSFFont font = wb.createFont();                                  //创建字体
        font.setFontName("微软雅黑");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFFont.COLOR_RED);
        style.setFont(font);
        coommonStyle(wb,style);
        return style;
    }

    /**
     * 头部样式
     */
    public static HSSFCellStyle headStyle(HSSFWorkbook wb){
        HSSFCellStyle headStyle = wb.createCellStyle();                       //创建样式对象
        HSSFFont headFont = wb.createFont();                                  //创建字体
        headFont.setFontName("微软雅黑");
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headFont.setColor(HSSFFont.COLOR_RED);
        headStyle.setFont(headFont);
        coommonStyle(wb,headStyle);
        return headStyle;
    }


    /**
     * 内容行样式
     */
    public static HSSFCellStyle contentStyle(HSSFWorkbook wb){
        HSSFCellStyle contentStyle = wb.createCellStyle();
        HSSFFont contentFont = wb.createFont();
        contentFont.setFontName("微软雅黑");
        contentFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        contentFont.setColor(HSSFFont.COLOR_NORMAL);
        contentStyle.setFont(contentFont);
        coommonStyle(wb,contentStyle);
        return contentStyle;
    }

    /**
     * 通用样式
     */
    public static HSSFCellStyle coommonStyle(HSSFWorkbook wb,HSSFCellStyle style){
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式
        style.setWrapText(true); //设置自动换行
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框 细边线
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框 细边线
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框 细边线
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框 细边线
        return style;
    }


    public static void outPutContent(HttpServletResponse response,HSSFWorkbook wb,String fileName){
        OutputStream os = null;
        Date creatTime = new Date();
        String ct = DateUtil.fomatToYYYYMMddHHmmss(creatTime);
        try {
            fileName = new String((fileName+"_"+ct+".xls").getBytes("UTF-8"),"ISO-8859-1");
            response.setContentType("application/vn.ms-excel");
            response.setHeader("Content-Disposition","attachment; filename="+fileName);
            response.setCharacterEncoding("utf-8");
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
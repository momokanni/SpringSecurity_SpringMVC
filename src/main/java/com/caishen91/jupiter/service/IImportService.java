package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.ExcelHandle;

import java.util.List;

public interface IImportService {
	
	void addExcelHandle(ExcelHandle excelHandle);

	List<ExcelHandle> getExcelHandleList(int status);

	boolean handleExcelHandle(ExcelHandle excelHandle);

	void updateExcelHandle(ExcelHandle excelHandle);

	void updateExcelHandleNums(ExcelHandle excelHandle);

	ExcelHandle getExcelHandleById(int id);

    ExcelHandle getExcelHandleByFileAndMD5(String fileName, String fileMD5);

    List<ExcelHandle> getExcelHandleAll();

	List<ExcelHandle> getExcelHandleByIds(List<Integer> excelHandleIds);
}

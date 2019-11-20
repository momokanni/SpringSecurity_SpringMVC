package com.caishen91.jupiter.service.impl;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.dao.*;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.util.excelutil.ExcelUtil;
import org.springframework.stereotype.Service;

import com.caishen91.jupiter.service.IImportService;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 38
 * Description:
 */
@Service
public class ImportServiceImpl extends BaseService implements IImportService {
	
	@Override
	public void addExcelHandle(ExcelHandle excelHandle) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		excelHandleMapper.addExcelHandle(excelHandle);
	}

	@Override
	public List<ExcelHandle> getExcelHandleList(int status) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		return excelHandleMapper.getExcelHandleList(status);
	}

	@Override
	public boolean handleExcelHandle(ExcelHandle excelHandle) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);

		excelHandle.setStatus(ExcelHandle.ExcelHandleStatus.initial.getStatus());
		excelHandle.setStartTime(new Date());
		excelHandleMapper.updateExcelHandle(excelHandle);

		File file = new File(excelHandle.getExcelFilePath());
		ExcelUtil.readExcel(file, excelHandle.getType(), excelHandle.getId());


		return false;
	}

	@Override
	public void updateExcelHandle(ExcelHandle excelHandle) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		excelHandleMapper.updateExcelHandleAll(excelHandle);
	}

	@Override
	public ExcelHandle getExcelHandleById(int id) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		return excelHandleMapper.getExcelHandleById(id);
	}

	@Override
	public void updateExcelHandleNums(ExcelHandle excelHandle) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		excelHandleMapper.updateExcelHandleNums(excelHandle);
	}

	@Override
	public ExcelHandle getExcelHandleByFileAndMD5(String fileName, String fileMD5) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		return excelHandleMapper.getExcelHandleByFileAndMD5(fileName, fileMD5);
	}

	@Override
	public List<ExcelHandle> getExcelHandleAll() {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		return excelHandleMapper.getExcelHandleAll();
	}

	@Override
	public List<ExcelHandle> getExcelHandleByIds(List<Integer> excelHandleIds) {
		ExcelHandleMapper excelHandleMapper = writableSQLSession.getMapper(ExcelHandleMapper.class);
		Map<String, List<Integer>> paramMap = new HashMap<>();
		paramMap.put("excelHandleIds", excelHandleIds);
		return excelHandleMapper.getExcelHandleByIds(paramMap);
	}
}

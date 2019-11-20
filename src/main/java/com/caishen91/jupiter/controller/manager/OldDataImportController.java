package com.caishen91.jupiter.controller.manager;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caishen91.jupiter.model.ExcelHandle;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.service.IImportService;
import com.caishen91.jupiter.util.StringUtil;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/manager/olddata")
public class OldDataImportController {
	
	private static final long serialVersionUID = 2334613357626895301L;

	// @Autowired
	// private IAuthorityService authorityService;

	@Autowired
	private IImportService importService;
	
	@Autowired
	private HttpServletRequest request;


	@RequestMapping("/updateExcelFile")
	@ResponseBody
	public Map<String,Object> updateFaeCliqueFile(@RequestParam(value = "excelFile", required = false) MultipartFile excelFile, String type) {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(Config.RET, Config.RET_ERROR);

		if (StringUtil.isEmpty(type)) {
			retMap.put(Config.ERR_MSG, "请选择文件类别");
			return retMap;
		}
		if (null == excelFile) {
			retMap.put(Config.ERR_MSG, "请选择上传文件");
			return retMap;
		}

		String originalFilename = excelFile.getOriginalFilename();
		//String newFileName = type + "_" + DateUtil.formatDate(new Date(), "yyyyMMddHHmmss") + originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		long fileSize = excelFile.getSize();
		String fileMD5 = StringUtil.MD5Encode(originalFilename + fileSize);

		if (verificationFile(originalFilename, fileMD5)) {
			retMap.put(Config.ERR_MSG, "文件已存在");
			return retMap;
		}

		ExcelHandle.ExcelHandleType excelHandleType = ExcelHandle.ExcelHandleType.getExcelHandleType(type);
		String path = Config.EXCEL_FILE_PATH;
		Date date = new Date();
		if (null != excelHandleType) {
			path += excelHandleType.getType() + DateUtil.formatDate(date, "/yyyy/MM/dd/") + originalFilename;
		} else {
			path += DateUtil.formatDate(date, "/yyyy/MM/dd/") + originalFilename;
		}

		File file = new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		try {
			excelFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
			retMap.put(Config.ERR_MSG, "文件导入失败");
			return retMap;
		}

		ExcelHandle excelHandle = new ExcelHandle();
		excelHandle.setStatus(ExcelHandle.ExcelHandleStatus.firstStatus.getStatus());
		excelHandle.setType(ExcelHandle.ExcelHandleType.clique.getType());
		excelHandle.setFileName(originalFilename);
		excelHandle.setFileMD5(fileMD5);
		excelHandle.setCreateTime(new Date());
		excelHandle.setExcelFilePath(path);

		try{
			importService.addExcelHandle(excelHandle);
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put(Config.ERR_MSG, "文件导入失败");
			return retMap;
		}

		retMap.put(Config.RET, Config.RET_OK);
		retMap.put(Config.RET_DATA, IDEncryptor.getInstance().encryptWithoutException(excelHandle.getId()));

		return retMap;
	}

	@RequestMapping("/toOldDataImport")
	public String toOldDataImport(HttpServletRequest request, HttpServletResponse response) {
		SysUser sysUser = LoginUtil.getSysLoginUser(request, response);
		if (null == sysUser) {
			return "/manager/login";
		}

		String typeStr = request.getParameter("t");
		ExcelHandle.ExcelHandleType type = ExcelHandle.ExcelHandleType.getExcelHandleType(typeStr);
		if (StringUtil.isNotEmpty(typeStr) && null != type) {
			request.setAttribute("type", type.getType());
		}

		return "/manager/oldDataImport/oldDataImport";
	}


	@RequestMapping("/queryImportResult")
	@ResponseBody
	public Map<String,Object> queryImportResult() {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(Config.RET, Config.RET_OK);

		List<ExcelHandle> excelHandles = importService.getExcelHandleAll();
		if (null != excelHandles &&excelHandles.size() > 0) {
			retMap.put(Config.RET_DATA, handleExcelData(excelHandles));
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
		}

		return retMap;
	}

	@RequestMapping("/getExcelHandleByIds")
	@ResponseBody
	public Map<String,Object> getExcelHandleByIds(@RequestParam(value = "eids") String excelHandleIdStr) {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(Config.RET, Config.RET_OK);

		String[] excelHandleIdStrArray = excelHandleIdStr.split(",");
		List<Integer> excelHandleIds = Arrays.stream(excelHandleIdStrArray)
				.map(eIdStr -> IDEncryptor.getInstance().decryptWithoutException(eIdStr)).collect(Collectors.toList());
		List<ExcelHandle> excelHandles = importService.getExcelHandleByIds(excelHandleIds);
		if (null != excelHandles &&excelHandles.size() > 0) {
			retMap.put(Config.RET_DATA, handleExcelData(excelHandles));
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
		}

		return retMap;
	}

	private Map<String, Object> handleExcelData(List<ExcelHandle> excelHandles) {
		List<Map<String,Object>> resultMapList = new ArrayList<>();
		for (ExcelHandle excelHandle : excelHandles) {
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("id", IDEncryptor.getInstance().encryptWithoutException(excelHandle.getId()));
			resultMap.put("fileName", excelHandle.getFileName());
			resultMap.put("type", ExcelHandle.ExcelHandleType.getExcelHandleType(excelHandle.getType()).getDesc());
			resultMap.put("createTime", DateUtil.formatDate(excelHandle.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
			resultMap.put("total", excelHandle.getExcelTotal());
			resultMap.put("success", excelHandle.getHandleNums());
			resultMap.put("failNums", excelHandle.getFailNums());
			resultMap.put("repetitionNums", excelHandle.getRepetitionNums());
			if (excelHandle.getStatus() != ExcelHandle.ExcelHandleStatus.firstStatus.getStatus()) {
				int handleNums = excelHandle.getHandleNums() + excelHandle.getFailNums() + excelHandle.getRepetitionNums();
				resultMap.put("process", handleNums / excelHandle.getExcelTotal() * 100);
			}
			resultMap.put("status", ExcelHandle.ExcelHandleStatus.getExcelHandleStatus(excelHandle.getStatus()).getDesc());
			resultMapList.add(resultMap);
		}
		Map<String, Object> data = new HashMap<>();
		data.put("totalRows", excelHandles.size());
		data.put("nav", "");
		data.put("content", resultMapList);
		return data;
	}

	private boolean verificationFile(String fileName, String fileMd5) {
		ExcelHandle excelHandle = importService.getExcelHandleByFileAndMD5(fileName, fileMd5);
		return null != excelHandle;
	}
}

package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.ExcelHandle;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ExcelHandleMapper {

    @Insert("insert into excel_handle" +
            "                       (" +
            "                           status, fileName, fileMD5, excelTotal, handleNums, createTime, startTime, endTime, type, excelFilePath" +
            "                       ) " +
            "                 values(" +
            "                           #{status}, #{fileName}, #{fileMD5}, #{excelTotal}, #{handleNums}, #{createTime}, #{startTime}, #{endTime}, #{type}, #{excelFilePath}" +
            "                       )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addExcelHandle(ExcelHandle excelHandle);

    @Select("select * from excel_handle where `status` = #{status}")
    List<ExcelHandle> getExcelHandleList(@Param("status") int status);

    @Select("select * from excel_handle where id = #{id}")
    ExcelHandle getExcelHandleById(@Param("id") int id);

    @Update("update excel_handle set" +
            "                       `status` = #{status}, excelTotal = #{excelTotal}, handleNums = #{handleNums}, " +
            "                        createTime = #{createTime}, startTime = #{startTime}, endTime = #{endTime}, " +
            "                        type = #{type}, excelFilePath = #{excelFilePath} where id = #{id}")
    void updateExcelHandleAll(ExcelHandle excelHandle);

    @Update("update excel_handle set `status` = #{status}, startTime = #{startTime}, endTime = #{endTime} where id = #{id}")
    void updateExcelHandle(ExcelHandle excelHandle);

    @Update("update excel_handle set excelTotal = #{excelTotal}, handleNums = #{handleNums}, failNums = #{failNums}, repetitionNums = #{repetitionNums} where id = #{id}")
    void updateExcelHandleNums(ExcelHandle excelHandle);

    @Select("select * from excel_handle where fileName = #{fileName} and fileMD5 = #{fileMD5}")
    ExcelHandle getExcelHandleByFileAndMD5(@Param("fileName") String fileName, @Param("fileMD5") String fileMD5);

    @Select("select * from excel_handle")
    List<ExcelHandle> getExcelHandleAll();

    @SelectProvider(type = ExcelHandleProvider.class, method = "getExcelHandleByIds")
    List<ExcelHandle> getExcelHandleByIds(Map<String,List<Integer>> paramMap);
}

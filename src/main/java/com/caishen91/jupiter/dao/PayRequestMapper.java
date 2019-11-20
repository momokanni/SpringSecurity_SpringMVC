package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.PayRequestInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: jgn
 * @Date: 3/8/19 12 41
 * Description:
 */
public interface PayRequestMapper {

    @Insert("insert into pay_request_info (synLoanRecordId,requestTime,requestInfo,responseInfo,responseCode,responseMess,statusCode,exceptionName,requestUrl)" +
            "                           values" +
            "                               (#{synLoanRecordId},#{requestTime},#{requestInfo},#{responseInfo},#{responseCode},#{responseMess},#{statusCode},#{exceptionName},#{requestUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addPayRequestInfo(PayRequestInfo pri);


    @Update("update pay_request_info set responseInfo = #{responseInfo},responseCode =#{responseCode}," +
            "                       responseMess = #{responseMess},statusCode = #{statusCode},exceptionName = #{exceptionName} where id = #{id}")
    void updateAfterResponse(PayRequestInfo pri);
}

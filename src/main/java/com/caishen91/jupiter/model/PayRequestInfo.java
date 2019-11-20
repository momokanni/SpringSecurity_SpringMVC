package com.caishen91.jupiter.model;

import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/8/19 10 26
 * Description:
 */
public class PayRequestInfo {

    /**
     * CREATE TABLE `pay_request_info` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `requestTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
     *   `requestInfo` text NOT NULL,
     *   `responseInfo` varchar(512) DEFAULT NULL,
     *   `responseCode` varchar(64) DEFAULT NULL,
     *   `responseMess` varchar(64) DEFAULT NULL,
     *   `statusCode` int(10) unsigned NOT NULL DEFAULT '0',
     *   `exceptionName` varchar(256) DEFAULT NULL,
     *   `requestUrl` varchar(256) DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */

    private int id;

    private Date requestTime;

    private String requestInfo;

    private String responseInfo;

    private String responseCode;

    private String responseMess;

    private int statusCode;

    private String exceptionName;

    private String requestUrl;

    private int synLoanRecordId;

    public int getSynLoanRecordId() {
        return synLoanRecordId;
    }

    public void setSynLoanRecordId(int synLoanRecordId) {
        this.synLoanRecordId = synLoanRecordId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(String responseInfo) {
        this.responseInfo = responseInfo;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMess() {
        return responseMess;
    }

    public void setResponseMess(String responseMess) {
        this.responseMess = responseMess;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}

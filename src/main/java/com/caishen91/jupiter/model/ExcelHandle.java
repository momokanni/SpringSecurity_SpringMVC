package com.caishen91.jupiter.model;

import java.util.Date;

public class ExcelHandle {

    private int id;

    private int status;

    private String fileName;

    private String fileMD5;

    private int excelTotal;

    private int handleNums;

    private int failNums;

    private int repetitionNums;

    private Date createTime;

    private Date startTime;

    private Date endTime;

    private String type;

    private String excelFilePath;

    private String failCause;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public int getExcelTotal() {
        return excelTotal;
    }

    public void setExcelTotal(int excelTotal) {
        this.excelTotal = excelTotal;
    }

    public int getHandleNums() {
        return handleNums;
    }

    public void setHandleNums(int handleNums) {
        this.handleNums = handleNums;
    }

    public int getFailNums() {
        return failNums;
    }

    public void setFailNums(int failNums) {
        this.failNums = failNums;
    }

    public int getRepetitionNums() {
        return repetitionNums;
    }

    public void setRepetitionNums(int repetitionNums) {
        this.repetitionNums = repetitionNums;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExcelFilePath() {
        return excelFilePath;
    }

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public String getFailCause() {
        return failCause;
    }

    public void setFailCause(String failCause) {
        this.failCause = failCause;
    }

    public static enum ExcelHandleStatus {

        firstStatus(0, "基础状态"),
        initial(1, "开始发起任务"),
        receiving(2, "处理excel"),
        connectErr(3, "处理错误"),
        giveUP(4, "放弃此次任务"),
        receiveSucc(5, "处理成功"),
        ;

        private int status;

        private String desc;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        ExcelHandleStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public static ExcelHandleStatus getExcelHandleStatus(int status) {
            for(ExcelHandleStatus excelHandleStatus : values()) {
                if(excelHandleStatus.getStatus() == status) {
                    return excelHandleStatus;
                }
            }

            return null;
        }
    }

    public static enum ExcelHandleType{

        clique("clique", "集团"),
        danbao("danbao", "担保方"),
        issue("issue", "发行方"),
        underwriter("underwriter", "承销商"),
        entrusted("entrusted", "受托管理人"),
        investor("investor", "投资人"),
        ;

        private String type;

        private String desc;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        ExcelHandleType(String type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static ExcelHandleType getExcelHandleType(String type){
            for (ExcelHandleType excelHandleType : values()) {
                if (excelHandleType.getType().equals(type)) {
                    return excelHandleType;
                }
            }
            return null;
        }
    }
}

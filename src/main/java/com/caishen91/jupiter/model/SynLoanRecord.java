package com.caishen91.jupiter.model;

import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/8/19 11 09
 * Description:
 */
public class SynLoanRecord {
    /**
     * CREATE TABLE `syn_loan_record` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `startTime` datetime NOT NULL COMMENT '开始时间',
     *   `endTime` datetime NOT NULL COMMENT '结束时间',
     *   `status` int(11) NOT NULL COMMENT '0-开始同步,1-同步中,2-同步成功,3-失败',
     *   `createTime` datetime NOT NULL,
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */

    private int id;

    private Date startTime;

    private Date endTime;

    private int status;

    private Date createTime;

    public static enum RecordStatus{

        startSyn(0,"开始同步"),
        syning(1,"同步中"),
        succ(2,"同步成功"),
        fail(3,"失败"),
        ;

        private int status;

        private String desc;

        RecordStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

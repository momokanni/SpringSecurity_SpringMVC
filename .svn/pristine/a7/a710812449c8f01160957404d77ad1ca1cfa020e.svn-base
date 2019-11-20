package com.caishen91.jupiter.model;

import java.util.Date;

public class Notice {

    private int id;

    private String title;

    private String content;//内容

    private int status;//状态

    private int type;//公告类型

    private int validType;//发布类型

    private Date releaseTime;//发布时间

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValidType() {
        return validType;
    }

    public void setValidType(int validType) {
        this.validType = validType;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    //公告状态枚举值
    public static enum NoticeStatus{
        toBeReleased(1, "待发布"),
        hasBeenReleased(2, "已发布"),
        failure(3, "已撤回"),
        ;

        private int id;

        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        NoticeStatus(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static NoticeStatus getNoticeStatus(int id) {
            for (NoticeStatus noticeStatus : values()) {
                if (noticeStatus.getId() == id) {
                    return noticeStatus;
                }
            }
            return null;
        }
    }


    //公告类型枚举值
    public static enum NoticeType{
        insidePlatform(1, "平台内部"),
        merchant(2, "商户"),
        whole(3, "全部"),
        ;

        private int id;

        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        NoticeType(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static NoticeType getNoticeType(int id) {
            for (NoticeType noticeType : values()) {
                if (noticeType.getId() == id) {
                    return noticeType;
                }
            }
            return null;
        }
    }
}

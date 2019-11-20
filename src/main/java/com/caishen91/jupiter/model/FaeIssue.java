package com.caishen91.jupiter.model;

import java.util.Date;

/**
 * 发行人
 */

public class FaeIssue {

    private int id;

    private String name;

    private String shortName;

    private String creditCode;

    private int cliqueId;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public int getCliqueId() {
        return cliqueId;
    }

    public void setCliqueId(int cliqueId) {
        this.cliqueId = cliqueId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

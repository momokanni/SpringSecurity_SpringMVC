package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 2/25/19 10 05
 * Description:用户bean
 */
public class User {
    /**
     * CREATE TABLE `user_main` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `userName` varchar(64) NOT NULL COMMENT '用户名',
     *   `password` varchar(255) NOT NULL,
     *   `realName` varchar(64) DEFAULT NULL COMMENT '姓名',
     *   `mobile` varchar(64) NOT NULL,
     *   `inviteCode` varchar(128) DEFAULT NULL COMMENT '邀请码',
     *   `refCode` varchar(128) DEFAULT NULL COMMENT '受邀码',
     *   `idCardType` varchar(64) DEFAULT NULL COMMENT '身份证 PRC_ID 、护照 PASSPORT 、港澳台同胞回乡证 COMPATRIOTS_CARD、外国人永久居住证 PERMANENT_RESIDENCE',
     *   `idCardNo` varchar(128) DEFAULT NULL,
     *   `status` int(2) NOT NULL DEFAULT '0' COMMENT '0-正常,1-禁用',
     *   `registerTime` datetime NOT NULL,
     *   `registerChannel` varchar(128) DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */

    private int id;

    private String userName;

    private String password;

    private String realName;

    private String mobile;

    private String inviteCode;

    private String refCode;

    private String idCardType;

    private String idCardNo;//证件号

    private int status;

    private Date registerTime;

    private String registerChannel;
    
    private boolean clerk; //是否是经纪人
    
    private BigDecimal roytalTop; //提成top值
    
    private int clerkRoleId; //内部用户roleId
    
    public int getClerkRoleId() {
		return clerkRoleId;
	}

	public void setClerkRoleId(int clerkRoleId) {
		this.clerkRoleId = clerkRoleId;
	}

	public BigDecimal getRoytalTop() {
		return roytalTop;
	}

	public void setRoytalTop(BigDecimal roytalTop) {
		this.roytalTop = roytalTop;
	}

	public boolean isClerk() {
		return clerk;
	}

	public void setClerk(boolean clerk) {
		this.clerk = clerk;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterChannel() {
        return registerChannel;
    }

    public void setRegisterChannel(String registerChannel) {
        this.registerChannel = registerChannel;
    }

    public static enum UserStatus{
        vaild(0,"有效"),
        expired(1,"禁用");


        private int status;

        private String desc;

        UserStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public static UserStatus getUserStatusByStatus(int sta) {

            for(UserStatus us : values()){
                if(us.getStatus() == sta)
                    return us;
            }
            return null;
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
}

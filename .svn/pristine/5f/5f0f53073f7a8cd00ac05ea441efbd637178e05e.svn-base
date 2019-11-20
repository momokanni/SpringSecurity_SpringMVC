package com.caishen91.jupiter.enums;

/**
 * 	公众号账号类型
 * @author Administrator
 *
 */
public enum RoleType {

	MANAGER(0,"超级管理员"),
	OTHER(1,"其他")
	;
	
	private int type;
	
	private String msg;
	
	private RoleType(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static RoleType getBlogType(int type) {
        for (RoleType roleType : values()) {
            if (roleType.getType() == type) {
                return roleType;
            }
        }
        return null;
    }
}

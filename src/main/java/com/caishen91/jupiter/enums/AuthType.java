package com.caishen91.jupiter.enums;

/**
 * 	权限类型
 * @author Administrator
 *
 */
public enum AuthType {

	MENU(0,"菜单"),
	OTHER(1,"其他权限")
	;
	
	private int type;
	
	private String msg;
	
	private AuthType(int type, String msg) {
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
	
	public static AuthType getBlogType(int type) {
        for (AuthType blogType : values()) {
            if (blogType.getType() == type) {
                return blogType;
            }
        }
        return null;
    }
}

package com.caishen91.jupiter.enums;

/**
 * 	公众号账号类型
 * @author Administrator
 *
 */
public enum BlogManagerType {

	NON_ADMIN(0,"非管理员"),
	ADMIN(1,"管理员")
	;
	
	private int type;
	
	private String msg;
	
	private BlogManagerType(int type, String msg) {
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
	
	public static BlogManagerType getBlogType(int type) {
        for (BlogManagerType bmType : values()) {
            if (bmType.getType() == type) {
                return bmType;
            }
        }
        return null;
    }
}

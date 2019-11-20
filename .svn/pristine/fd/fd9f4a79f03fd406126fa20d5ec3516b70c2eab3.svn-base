package com.caishen91.jupiter.enums;

/**
 * 	公众号账号类型
 * @author Administrator
 *
 */
public enum BlogType {

	PERSONAL(0,"个人"),
	COMPANY(1,"公司")
	;
	
	private int type;
	
	private String msg;
	
	private BlogType(int type, String msg) {
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
	
	public static BlogType getBlogType(int type) {
        for (BlogType blogType : values()) {
            if (blogType.getType() == type) {
                return blogType;
            }
        }
        return null;
    }
}

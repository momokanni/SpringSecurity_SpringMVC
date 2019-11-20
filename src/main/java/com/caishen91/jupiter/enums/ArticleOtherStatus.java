package com.caishen91.jupiter.enums;

/**
 * 	权限类型
 * @author Administrator
 *
 */
public enum ArticleOtherStatus {
	
	NO_STATUS(0,"无状态"),
	PENDING_SHARING(1,"待分享"),
	;
	
	private int type;
	
	private String msg;
	
	private ArticleOtherStatus(int type, String msg) {
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
	
	public static ArticleOtherStatus getBlogType(int type) {
        for (ArticleOtherStatus blogType : values()) {
            if (blogType.getType() == type) {
                return blogType;
            }
        }
        return null;
    }
}

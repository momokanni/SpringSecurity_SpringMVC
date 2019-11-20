package com.caishen91.jupiter.enums;

/**
 * 	公众号--文章种类
 * @author Administrator
 *
 */
public enum CategoryType {

	ARTICLE_IMG(0,"图文"),
	ARTICLE_VIDEO(1,"视频")
	;
	
	private int code;
	
	private String desc;
	
	private CategoryType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static CategoryType getCategoryType(int type) {
        for (CategoryType blogType : values()) {
            if (blogType.getCode() == type) {
                return blogType;
            }
        }
        return null;
    }
}

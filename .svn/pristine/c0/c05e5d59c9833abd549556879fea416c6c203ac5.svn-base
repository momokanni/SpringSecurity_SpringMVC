package com.caishen91.jupiter.enums;

/**
 * 	文章发布形式
 * @author Administrator
 *
 */
public enum ArticleReleaseType {

	TIMING(0,"定时发布"),
	RIGHT_NOW(1,"立即发布")
	;
	
	private ArticleReleaseType(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	private int code;
	
	private String msg;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static ArticleReleaseType getArticleReleaseType(int code) {
        for (ArticleReleaseType art : values()) {
            if (art.getCode() == code) {
                return art;
            }
        }
        return null;
    }
}

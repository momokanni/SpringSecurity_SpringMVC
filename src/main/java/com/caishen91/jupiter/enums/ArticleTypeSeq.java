package com.caishen91.jupiter.enums;

/**
 * 	文章类型排序枚举
 * @author Administrator
 *
 */
public enum ArticleTypeSeq {

	RECOMMEND(1,"推荐")
	;
	
	private int seq;
	
	private String msg;
	
	private ArticleTypeSeq(int seq, String msg) {
		this.seq = seq;
		this.msg = msg;
	}
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static ArticleTypeSeq getArticleTypeSeq(int seq) {
        for (ArticleTypeSeq articleTypeSeq : values()) {
            if (articleTypeSeq.getSeq() == seq) {
                return articleTypeSeq;
            }
        }
        return null;
    }
}

package com.caishen91.jupiter.model;

public class ArticleCollection extends BaseEntity {


	private static final long serialVersionUID = 1L;

	private int articleId;

    private int userId;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}

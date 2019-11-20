package com.caishen91.jupiter.model;

public class ArticleKeyWords extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int blogId;
	
	private String name;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

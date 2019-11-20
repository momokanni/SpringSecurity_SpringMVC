package com.caishen91.jupiter.model;

import java.util.List;

public class AuthTree {

	/**
     * 	唯一编号 uuid
     */
    private String id;

    /**
     *	 名称
     */
    private String title;

    /**
     * 	父节点id
     */
    private String parentId;
    /**
     * 	是否选中
     */
    private boolean checked = false;
    /**
     * 	子节点(数据库中不存在该字段，仅用于传输数据使用)
     */
    private List<?> children;
    
    private int level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<?> getChildren() {
		return children;
	}

	public void setChildren(List<?> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

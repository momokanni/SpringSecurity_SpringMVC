package com.caishen91.jupiter.model;

import java.util.List;

public class BaseAuthTree {

	/**
     * 	唯一编号 uuid
     */
    private String id;
    /**
     *	 名称
     */
    private String name;
    /**
     * 	子节点(数据库中不存在该字段，仅用于传输数据使用)
     */
    private List<? extends BaseAuthTree> children;


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<? extends BaseAuthTree> getChildren() {
		return children;
	}

	public void setChildren(List<? extends BaseAuthTree> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

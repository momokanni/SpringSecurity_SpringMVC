package com.caishen91.jupiter.model;

public class BlogMenuTree extends BaseAuthTree{

    /**
     * 	父节点id
     */
    private String parentId;
    /**
     * 	菜单路径
     */
    private String url;
    /**
     *	菜单标签id属性值
     */
    private String elementId;
    
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
}

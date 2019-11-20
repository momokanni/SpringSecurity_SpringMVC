package com.caishen91.jupiter.model;

import java.util.Date;

/**
 *  	请求小油菜接口实体
 */
public class ShareForRequest {
	
	private String fkId;
	private String title;
	private String pic;
	private int shareType;
	private String shareTitle;
	private String shareContent;
	private String categoryId;
	private int seq;
	private int status;
	private Date createTime;
	private Date updateTime;
	private int titleCount;
	private int picCount;
	private String audioUrl;
	private String vedioUrl;
	private int sourceId;
	private String label;
	
	
	public String getFkId() {
		return fkId;
	}
	public void setFkId(String fkId) {
		this.fkId = fkId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getShareType() {
		return shareType;
	}
	public void setShareType(int shareType) {
		this.shareType = shareType;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareContent() {
		return shareContent;
	}
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getTitleCount() {
		return titleCount;
	}
	public void setTitleCount(int titleCount) {
		this.titleCount = titleCount;
	}
	public int getPicCount() {
		return picCount;
	}
	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	public String getVedioUrl() {
		return vedioUrl;
	}
	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}

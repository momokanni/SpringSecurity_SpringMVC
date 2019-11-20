package com.caishen91.jupiter.vo;

import java.util.Date;

import com.caishen91.jupiter.model.BaseEntity;
import com.caishen91.jupiter.util.DateUtil;

/**
 * 	编辑文章VO
 * @author Administrator
 *
 */
public class ARDetailVO extends BaseEntity {

	private static final long serialVersionUID = -4739557550221764214L;
	
    // 标题
    private String title;
    // 文章内容
    private String content;
    // 文章类型
    private int type;
    // 公众号标签
    private int label;
    // 首图
    private String url;
    // 发布时间
    private String time;
    // 音频路径
    private String audioPath;
    // 音频文件名称
    private String audioName;
    // 分享内容
    private String shareContent;
    // 图片个数
    private int imgCount;
    // 文章字数
    private int wordCount;
    // 文章来源
    private String articleSourceId;
    // 其他状态
    private String otherStatus;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time =time;
	}
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	public String getAudioName() {
		return audioName;
	}
	public void setAudioName(String audioName) {
		this.audioName = audioName;
	}
	public String getShareContent() {
		return shareContent;
	}
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	public int getImgCount() {
		return imgCount;
	}
	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}
	public int getWordCount() {
		return wordCount;
	}
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	public String getArticleSourceId() {
		return articleSourceId;
	}
	public void setArticleSourceId(String articleSourceId) {
		this.articleSourceId = articleSourceId;
	}
	public String getOtherStatus() {
		return otherStatus;
	}
	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}
}

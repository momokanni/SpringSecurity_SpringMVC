package com.caishen91.jupiter.dto;


public class ArticleDTO{

	private String id;
	// 文章标题
	private String title;
	// 文章内容
	private String content;
	// 文章类型
	private String type;
	// 文章标签
	private String label;
	// 首图
	private String thumb;
	// 发布类型
	private String releaseType;
	// 发布时间
	private String time;
	// 公众号ID
	private int blogId;
	// 公众号操作人员ID
	private int managerId;
	// 文章状态
	private String status;
	// 查询发布时间范围 -- 开始时间
	private String startTime;
	// 查询发布时间范围 -- 结束时间
	private String endTime;
	// 音频路径
    private String audioPath;
    // 音频文件名称
    private String audioName;
    // 分享内容
    private String shareContent;
    // 图片个数
    private Integer imgCount;
    // 文章字数
    private Integer wordCount;
    // 文章来源
    private String articleSource;
    // 文章来源ID
    private Integer articleSourceId;
    // 其他状态
    private String otherStatus;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getReleaseType() {
		return releaseType;
	}
	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public Integer getImgCount() {
		return imgCount;
	}
	public void setImgCount(Integer imgCount) {
		this.imgCount = imgCount;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public String getArticleSource() {
		return articleSource;
	}
	public void setArticleSource(String articleSource) {
		this.articleSource = articleSource;
	}
	public Integer getArticleSourceId() {
		return articleSourceId;
	}
	public void setArticleSourceId(Integer articleSourceId) {
		this.articleSourceId = articleSourceId;
	}
	public String getOtherStatus() {
		return otherStatus;
	}
	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}
	public String getStart() {
		if(getStartTime() == null || getStartTime().equals("")) {
			return null;
		}
		return getStartTime() + " 00:00:00"; 
	}
	
	public String getEnd() {
		if(getEndTime() == null || getEndTime().equals("")) {
			return null;
		}
		return getEndTime() + " 23:59:59";
	}
}

package com.caishen91.jupiter.model;

import java.util.Date;

public class Article extends BaseEntity{

	private static final long serialVersionUID = 2878324023450077486L;
	
	// 编号
    private String number;
    // 标题
    private String title;
    // 内容
    private String content;
    // 文章种类
    private int category;
    // 文章类型
    private int typeId;
    // 公众号标签
    private int labelId;
    // 缩略图地址
    private String thumb;
    // 阅读量
    private int readCount;
    // 收藏量
    private int collecCount;
    // 转发量
    private int forwardCount;
    //点赞量
    private int laudCount;
    // 置顶
    private int ontop;
    // 公众号ID
    private int blogId;
    // 文章发布操作员ID
    private int blogManagerId;
    // 状态
    private int status;
    // 发布时间
    private Date releaseTime;
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
    // 分享状态
    private int share;
    // 文章来源
    private String source;
    // 文章来源ID
    private int sourceId;
    // 其他状态
    private String otherStatus;

    public int getLaudCount() {
        return laudCount;
    }

    public void setLaudCount(int laudCount) {
        this.laudCount = laudCount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getCollecCount() {
        return collecCount;
    }

    public void setCollecCount(int collecCount) {
        this.collecCount = collecCount;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public int getOntop() {
        return ontop;
    }

    public void setOntop(int ontop) {
        this.ontop = ontop;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getBlogManagerId() {
		return blogManagerId;
	}

	public void setBlogManagerId(int blogManagerId) {
		this.blogManagerId = blogManagerId;
	}

	public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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
	
	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getOtherStatus() {
		return otherStatus;
	}

	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}




	//文章种类枚举值
    public static enum ArticleCategory{
        imageText(0, "图文"),
        video(1, "视频"),

        ;

        private int id;

        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        ArticleCategory(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static ArticleCategory getArticleCategory(int id) {
            for (ArticleCategory articleCategory : values()) {
                if (articleCategory.getId() == id) {
                    return articleCategory;
                }
            }
            return null;
        }
    }



    //文章是否置顶枚举值
    public static enum ArticleOntop{
        no(0, "否"),
        top(1, "置顶"),

        ;

        private int id;

        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        ArticleOntop(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static ArticleOntop getArticleOntop(int id) {
            for (ArticleOntop articleOntop : values()) {
                if (articleOntop.getId() == id) {
                    return articleOntop;
                }
            }
            return null;
        }
    }



    //文章状态枚举值
    public static enum ArticleStatus{
        toBeReleased(1, "待发布"),
        hasBeenReleased(2, "已发布"),
        draft(3, "草稿"),
        Offline(4, "已下线"),
        DEL(5,"已删除")
        ;

        private int id;

        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        ArticleStatus(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static ArticleStatus getArticleStatus(int id) {
            for (ArticleStatus articleStatus : values()) {
                if (articleStatus.getId() == id) {
                    return articleStatus;
                }
            }
            return null;
        }
    }
}

package com.caishen91.jupiter.model;

import com.caishen91.jupiter.enums.CommonStatus;

public class ArticleType extends BaseEntity{


	private static final long serialVersionUID = -1008134965220647651L;

	private String name;

    private int status;
    
    private int seq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public boolean isAvailable() {
        return status == CommonStatus.available.getStatus();
    }


}


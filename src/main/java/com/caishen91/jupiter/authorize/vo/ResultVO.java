package com.caishen91.jupiter.authorize.vo;

import java.io.Serializable;

public class ResultVO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 /**
     * 返回码
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;
    
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
    
    

}

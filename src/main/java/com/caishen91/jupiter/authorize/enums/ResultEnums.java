package com.caishen91.jupiter.authorize.enums;

public enum ResultEnums {
	
	 /**
     * system errors
     */
    SUCCESS(200,"成功"),
    FAILED(201,"失败"),
    UNKONW(202,"未知错误"),
    PARAM_ERROR(203,"参数不正确"),
    PARAM_CONVERT_ERROR(204,"参数转换异常"),
    SYSTEM_ERROR(205,"系统错误"),
    /**
     * User exception
     */
    UNAUTHORIZED_ACCESS(401,"无访问权限"),
    USER_NOT_EXISTS(402,"用户不存在"),
    USER_CREATE_ERROR(403,"用户创建失败"),
    AUTHENTICATION_EXCEPTOIN(405,"身份验证异常"),
    LOGIN_FAILURE(406,"用户名或密码错误"),
    ;

    private int code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}

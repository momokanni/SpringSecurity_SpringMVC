package com.caishen91.jupiter.enums;

/**
 * 	企业类型
 * @author Administrator
 *
 */
public enum EnterpriseType {
	INDIVIDUAL(0,"个体商户"),
	ENTERPRISE(1,"企业")
	;
	
	private int type;
	
	private String msg;
	
	private EnterpriseType(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static EnterpriseType getEnterpriseType(int type) {
        for (EnterpriseType enterpriseType : values()) {
            if (enterpriseType.getType() == type) {
                return enterpriseType;
            }
        }
        return null;
    }
}

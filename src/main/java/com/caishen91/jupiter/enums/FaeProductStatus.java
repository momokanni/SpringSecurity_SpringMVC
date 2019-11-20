package com.caishen91.jupiter.enums;

public enum FaeProductStatus {

	/*
	0-待提交,1-待审核,2-审核通过,3-审核驳回,4-待挂牌,5-待排期,6-排期中,7-投标中,8-已满标,9-已结清
	 */
	waitSubmit(0,"待提交"),
	waitExamine(1,"待审核"),
	passed(2,"审核通过"),
	refuse(3,"审核驳回"),
	waitHang(4,"待挂牌"),
	waitSchedue(5,"待排期"),
	scheduing(6,"排期中"),
	investing(7,"投标中"),
	full(8,"已满标"),
	settlemented(9,"已结清"),

	;

	private int status;

	private String desc;

	FaeProductStatus(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static FaeProductStatus getFaeProductStatusByStatus(int status){
		for(FaeProductStatus pls : values()){
			if(pls.getStatus() == status)
				return pls;
		}
		return null;
	}
}

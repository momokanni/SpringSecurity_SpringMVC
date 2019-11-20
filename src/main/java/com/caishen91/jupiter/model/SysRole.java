package com.caishen91.jupiter.model;

public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 5628314790222479135L;

    private String roleName;

    private String department;

    private int status;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

	public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package com.caishen91.jupiter.enums;


public enum SysRoleStatus {
	start(1, "启用"),
    stop(0, "禁用"),
    ;

    private int stauts;

    private String desc;

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    SysRoleStatus(int stauts, String desc) {
        this.stauts = stauts;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SysRoleStatus getSysroleStatus(int status) {
        for (SysRoleStatus sysRoleStatus : values()) {
            if (sysRoleStatus.getStauts() == status) {
                return sysRoleStatus;
            }
        }
        return null;
    }
}

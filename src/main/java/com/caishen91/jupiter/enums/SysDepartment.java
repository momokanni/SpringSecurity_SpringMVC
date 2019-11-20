package com.caishen91.jupiter.enums;

/**
 * 部门
 */
public enum SysDepartment {

    customerService("customerService", "客户部"),
    riskManagement("riskManagementcaiwu", "风控部"),
    product("product", "产品部"),
    assetManagement("assetManagement", "资管部"),
    finance("finance", "财务部"),
    ;

    private String type;

    private String desc;

    SysDepartment(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SysDepartment getSysDepartment(String type) {
        for (SysDepartment sysDepartment : values()) {
            if (sysDepartment.getType().equals(type)) {
                return sysDepartment;
            }
        }
        return null;
    }
}

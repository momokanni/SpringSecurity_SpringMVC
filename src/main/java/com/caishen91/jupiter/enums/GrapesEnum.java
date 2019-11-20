package com.caishen91.jupiter.enums;

public enum GrapesEnum {
	SUCCESS("0000", "请求成功", ""),
    FAIL("0001", "请求失败", ""),
    DATA_DECODE_FAIL("0002", "数据解密失败", ""),
    DATA_NULL("0003", "请求无数据", ""),
    DATA_FORMAT_ERROR("0004", "数据格式错误", ""),
    SYS_ANOMALY("0010", "系统异常", ""),
    ;


    private String code;

    private String message;

    private String desc;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDesc() {
        return desc;
    }

    GrapesEnum(String code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public static GrapesEnum getGrapesEnumByCode(String code) {
        for (GrapesEnum grapesEnum : values()) {
            if (grapesEnum.getCode().equals(code)) {
                return grapesEnum;
            }
        }
        return null;
    }
}

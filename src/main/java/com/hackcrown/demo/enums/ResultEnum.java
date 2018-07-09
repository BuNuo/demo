package com.hackcrown.demo.enums;

/**
 * @Auther: bunuo
 * @Date: 2018/7/5 21:33
 * @Description:
 */
public enum ResultEnum {
	SYSTEM_ERROR(-1, "系统异常"),
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    SYSUSER_NULL(201, "用户不存在"),
    NOT_LOGIN(301, "用户未登录"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package com.morgan.common;

public enum ResponseCode {

    SUCCESSS(200,"success"),

    SYSTEM_ERROR(500,"system error");

    private int code;

    private String msg;

    ResponseCode(int code, String msg) {
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

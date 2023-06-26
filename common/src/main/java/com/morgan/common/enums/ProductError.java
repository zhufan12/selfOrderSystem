package com.morgan.common.enums;

public enum ProductError implements ResponseError {

    PRODUCT_NOT_EXIST(4004,"prodcut not exised"),
    PRODUCT_STOCK_ERROR(4001,"prodcut stock error")
    ;

    ProductError(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

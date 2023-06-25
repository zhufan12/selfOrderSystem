package com.morgan.product.Vo;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseVo<T> {

    private int code;

    private String msg;

    private T data;

    public static ResponseVo successResponse(Object data) {
        return new ResponseVo(ResponseCode.SUCCESSS.getCode(),ResponseCode.SUCCESSS.getMsg(),data);
    }

    public static ResponseVo successResponse() {
        return new ResponseVo(ResponseCode.SUCCESSS.getCode(),ResponseCode.SUCCESSS.getMsg(),"");
    }


    public static ResponseVo errorResponse() {
        return new ResponseVo(ResponseCode.SYSTEM_ERROR);
    }

    public ResponseVo(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }


    public ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

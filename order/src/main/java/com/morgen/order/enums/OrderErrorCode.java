package com.morgen.order.enums;

import lombok.Getter;

@Getter
public enum OrderErrorCode {

    PARAMETER_ERROR(4003);

    OrderErrorCode(int code){
        this.code = code;
    }

    private int code;
}

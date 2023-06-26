package com.morgen.order.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PayStatus {

    WAIT,
    SUCCESS;

    PayStatus(){

    }

    @JsonValue
    public int getValue(){
        return ordinal();
    }
}

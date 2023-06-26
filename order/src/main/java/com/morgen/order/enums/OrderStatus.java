package com.morgen.order.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

    NEW,
    FINISHED,
    CANCLE;

    OrderStatus(){
    }

    @JsonValue
    public int getValue(){
        return ordinal();
    }
}

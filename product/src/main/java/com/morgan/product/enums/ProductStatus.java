package com.morgan.product.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {

    SALE,
    STOP_SALE;

    ProductStatus(){
    }
    @JsonValue
    public int getValue(){
        return ordinal();
    }
}

package com.morgan.product.exception;

import com.morgan.common.ResponseCode;
import com.morgan.common.enums.ProductError;
import com.morgan.common.enums.ResponseError;

public class ProductException extends RuntimeException{

    private int code;


    public ProductException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ProductException(ProductError responseCode) {
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
    }
}

package com.morgen.order.exception;

public class OrderException extends RuntimeException {


    private int code;

    public OrderException(int code) {
        this.code = code;
    }

    public OrderException(String message, int code) {
        super(message);
        this.code = code;
    }
}

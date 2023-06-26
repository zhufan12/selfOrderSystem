package com.morgan.common.dto;

import lombok.Data;

@Data
public class CartDTO {

    private Integer id;

    private Integer quantity;


    public CartDTO() {

    }

    public CartDTO(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

}

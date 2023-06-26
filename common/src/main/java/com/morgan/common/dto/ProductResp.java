package com.morgan.common.dto;



import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;



@Data
public class ProductResp implements Serializable {

    private Integer id;


    private String name;


    private BigDecimal price;


    private Integer stock;


    private String description;


    private String icon;


    private Integer status;

    private Integer categoryType;
}

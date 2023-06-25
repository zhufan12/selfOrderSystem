package com.morgan.product.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVos;

    @Data
    public static class ProductInfoVo{

        private Integer id;

        private String name;

        private BigDecimal price;

        private String description;

        private String icon;

    }


}

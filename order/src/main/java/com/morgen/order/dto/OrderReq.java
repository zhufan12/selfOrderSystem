package com.morgen.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderReq {
    @NotEmpty(message = "buyer Name can't be null")
    private String buyerName;
    @NotEmpty(message = "buyer Phone can't be null")
    private String buyerPhone;
    @NotEmpty(message = "buyer Address can't be null")
    private String buyerAddress;
    @NotEmpty(message = "buyer UUID can't be null")
    private String buyerUuid;
    @NotNull(message = "items can't be null")
    private List<ProductItem> items;

    @Data
    public static class ProductItem {
        private  Integer id;
        private Integer quantity;
    }
}

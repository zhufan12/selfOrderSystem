package com.morgen.order.dto;

import com.morgen.order.entity.OrderDetail;
import com.morgen.order.enums.OrderStatus;
import com.morgen.order.enums.PayStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

    private Integer id;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerUuid;
    private BigDecimal amount;

    private OrderStatus status;

    private PayStatus payStatus;


    private List<OrderDetail> items;

}

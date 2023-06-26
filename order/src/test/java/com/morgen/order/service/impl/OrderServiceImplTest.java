package com.morgen.order.service.impl;

import com.morgen.order.dto.OrderDTO;
import com.morgen.order.entity.OrderDetail;
import com.morgen.order.enums.OrderStatus;
import com.morgen.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {


    @Autowired
    private OrderService orderService;

    @Test
    void create() {

        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId(1);
        orderDetail.setProductQuantity(2);
        orderDetails.add(orderDetail);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("tester");
        orderDTO.setBuyerAddress("test address");
        orderDTO.setBuyerPhone("85212345678");
        orderDTO.setStatus(OrderStatus.NEW);
        orderDTO.setBuyerUuid(UUID.randomUUID().toString());

        orderDTO.setItems(orderDetails);


        orderService.create(orderDTO);
    }
}
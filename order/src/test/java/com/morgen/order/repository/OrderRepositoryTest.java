package com.morgen.order.repository;

import com.morgen.order.OrderApplicationTests;
import com.morgen.order.entity.Order;
import com.morgen.order.enums.OrderStatus;
import com.morgen.order.enums.PayStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Component
public  class OrderRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSave(){
        Order order = new Order();
        order.setAmount(new BigDecimal(10));
        order.setBuyerName("tester");
        order.setBuyerAddress("test address");
        order.setBuyerPhone("85212345678");
        order.setStatus(OrderStatus.NEW);
        order.setBuyerUuid(UUID.randomUUID().toString());
        order.setPayStatus(PayStatus.WAIT);
        Order save = orderRepository.save(order);
        assert save != null;
    }

}
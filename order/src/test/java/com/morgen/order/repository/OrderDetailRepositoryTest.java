package com.morgen.order.repository;

import com.morgen.order.OrderApplicationTests;
import com.morgen.order.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductIcon("test.jpg");
        orderDetail.setProductId(1);
        orderDetail.setOrderId(1);
        orderDetail.setProductName("test");
        orderDetail.setProductPrice(new BigDecimal(10));
        orderDetail.setProductQuantity(1);
        OrderDetail save = orderDetailRepository.save(orderDetail);
        assert save != null;
    }

}
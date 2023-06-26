package com.morgen.order.converter;

import com.morgen.order.dto.OrderDTO;
import com.morgen.order.dto.OrderReq;
import com.morgen.order.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderReqToOrderDTO {


    public static OrderDTO convert(OrderReq orderReq){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderReq.getBuyerName());
        orderDTO.setBuyerPhone(orderReq.getBuyerPhone());
        orderDTO.setBuyerUuid(orderReq.getBuyerUuid());
        orderDTO.setBuyerAddress(orderDTO.getBuyerAddress());

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderReq.getItems().forEach(item -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(item.getId());
            orderDetail.setProductQuantity(item.getQuantity());
        });
        orderDTO.setItems(orderDetails);
        return orderDTO;
    }
}

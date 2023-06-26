package com.morgen.order.service.impl;

import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import com.morgen.order.client.ProductClient;
import com.morgen.order.dto.OrderDTO;
import com.morgen.order.entity.Order;
import com.morgen.order.entity.OrderDetail;
import com.morgen.order.enums.OrderStatus;
import com.morgen.order.enums.PayStatus;
import com.morgen.order.repository.OrderDetailRepository;
import com.morgen.order.repository.OrderRepository;
import com.morgen.order.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Autowired
    private ProductClient productClient;


    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        List<Integer> ids  = orderDTO.getItems().stream().map(OrderDetail::getProductId).collect(Collectors.toList());

        List<ProductResp> products = productClient.findProductByIds(ids);
        Map<Integer,ProductResp>  productMap = products.stream().collect(Collectors.toMap(ProductResp::getId, Function.identity()));

        BigDecimal amount = new BigDecimal(0);
        for(OrderDetail orderDetail : orderDTO.getItems()){
            ProductResp product = productMap.get(orderDetail.getProductId());
            amount = product.getPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(amount);
            orderDetail.setProductName(product.getName());
            orderDetail.setProductPrice(product.getPrice());
            orderDetail.setProductIcon(product.getIcon());
        }

        List<CartDTO> cartDTOS =  orderDTO.getItems().stream().map(item -> {
            return  new CartDTO(item.getProductId(),item.getProductQuantity());
        }).collect(Collectors.toList());

        productClient.decreaseStock(cartDTOS);

        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        order.setAmount(amount);
        order.setPayStatus(PayStatus.WAIT);
        order.setStatus(OrderStatus.NEW);
        Order save = orderRepository.save(order);
        List<OrderDetail> orderDetails = orderDTO.getItems().stream().map(e -> {
            e.setOrderId(save.getId());
            return e;
        }).collect(Collectors.toList());
        orderDetailRepository.saveAll(orderDetails);
        orderDTO.setId(save.getId());
        return orderDTO;
    }
}

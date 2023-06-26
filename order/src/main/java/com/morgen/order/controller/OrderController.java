package com.morgen.order.controller;

import com.morgan.common.ResponseVo;
import com.morgen.order.client.ProductClient;
import com.morgen.order.converter.OrderReqToOrderDTO;
import com.morgen.order.dto.OrderDTO;
import com.morgen.order.dto.OrderReq;
import com.morgen.order.enums.OrderErrorCode;
import com.morgen.order.exception.OrderException;
import com.morgen.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/order")
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;


    @PostMapping("")
    public ResponseVo create(@Validated @RequestBody OrderReq orderReq, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("[create Order] Valid failed,order request: {}",orderReq);
            throw new OrderException(bindingResult.getFieldErrors().get(0).getDefaultMessage(), OrderErrorCode.PARAMETER_ERROR.getCode());
        }

        OrderDTO orderDTO = OrderReqToOrderDTO.convert(orderReq);
        orderDTO = orderService.create(orderDTO);

        Map<String,Integer> orderResp = new HashMap<>();
        orderResp.put("orderId",orderDTO.getId());
        return ResponseVo.successResponse(orderResp);
    }

}

package com.morgen.order.message;


import com.fasterxml.jackson.core.type.TypeReference;
import com.morgan.common.constant.Constant;
import com.morgan.common.dto.ProductResp;
import com.morgen.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductDecrease {

    private final static String PRODUCT_STOCK_TEMPLATE = "PRODUCT_STOCK_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RabbitListener(queuesToDeclare = {
            @Queue(
                    value = Constant.ProductQueue.DECREASE
            )
    })
    public void onMessage(String msg){
        List<ProductResp> productResp = (List<ProductResp>) JsonUtil.fromJson(msg,
                new TypeReference<List<ProductResp>>() {});
        log.info("FROM QUEUE [{}] get message : {}",Constant.ProductQueue.DECREASE,msg);
        productResp.stream().forEach(item -> {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,item.getId())
                    ,item.getStock().toString());
        });

    }
}

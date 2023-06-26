package com.morgen.order.client;

import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @PostMapping("/v1/product/listForOrder")
    List<ProductResp> findProductByIds(List<Integer> ids);

    @PostMapping("/v1/product/decreaseStock")
    void  decreaseStock(List<CartDTO> cartDTOS);

}

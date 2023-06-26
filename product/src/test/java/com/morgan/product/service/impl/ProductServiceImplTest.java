package com.morgan.product.service.impl;



import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import com.morgan.product.ProductApplicationTests;
import com.morgan.product.entity.Product;
import com.morgan.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void findSaleAll() {
        List<Product> products = productService.findSaleAll();
        assert products.size() > 0;
    }

    @Test
    void findList(){
        List<Integer> ids = Arrays.asList(1,2);
        List<ProductResp> products = productService.findList(ids);
        assert products.size() > 0;
    }


    @Test
    void decreaseStockTest(){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(1);
        cartDTO.setQuantity(2);

        CartDTO cartDTO2 = new CartDTO();
        cartDTO2.setId(1);
        cartDTO2.setQuantity(2);
        List<CartDTO> cartDTOS = new ArrayList<>();
        cartDTOS.add(cartDTO);

        productService.decreaseStock(cartDTOS);
    }
}
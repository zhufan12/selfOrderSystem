package com.morgan.product.service.impl;


import com.morgan.product.ProductApplicationTests;
import com.morgan.product.entity.Product;
import com.morgan.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
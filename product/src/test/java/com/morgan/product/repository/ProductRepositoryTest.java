package com.morgan.product.repository;

import com.morgan.product.entity.Product;
import com.morgan.product.enums.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByStatus() {
        List<Product> products = productRepository.findByStatus(ProductStatus.SALE);
        assert products.size() > 0;
    }


    @Test
    void findByIdIn(){
        List<Integer> ids = Arrays.asList(1,2);
        List<Product> products =productRepository.findByIdIn(ids);
        assert  products.size() > 0;
    }
}
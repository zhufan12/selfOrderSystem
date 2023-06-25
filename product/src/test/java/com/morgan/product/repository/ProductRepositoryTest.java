package com.morgan.product.repository;

import com.morgan.product.entity.Product;
import com.morgan.product.enums.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
}
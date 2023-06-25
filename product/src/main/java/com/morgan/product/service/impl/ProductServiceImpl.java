package com.morgan.product.service.impl;

import com.morgan.product.entity.Product;
import com.morgan.product.enums.ProductStatus;
import com.morgan.product.repository.ProductRepository;
import com.morgan.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findSaleAll() {
        return productRepository.findByStatus(ProductStatus.SALE);
    }
}

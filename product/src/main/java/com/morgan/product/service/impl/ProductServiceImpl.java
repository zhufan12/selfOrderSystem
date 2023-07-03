package com.morgan.product.service.impl;

import com.morgan.common.constant.Constant;
import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import com.morgan.common.enums.ProductError;
import com.morgan.product.entity.Product;
import com.morgan.product.enums.ProductStatus;
import com.morgan.product.exception.ProductException;
import com.morgan.product.repository.ProductRepository;
import com.morgan.product.service.ProductService;
import com.morgan.product.utils.JsonUtil;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<Product> findSaleAll() {
        return productRepository.findByStatus(ProductStatus.SALE);
    }

    @Override
    public List<ProductResp> findList(List<Integer> ids) {
        List<Product> products = productRepository.findByIdIn(ids);
        List<ProductResp> productResps = products.stream().map(e -> {
            ProductResp productResp = new ProductResp();
            BeanUtils.copyProperties(e,productResp);
            return productResp;
        }).collect(Collectors.toList());
        return  productResps;
    }

    @Override

    public void decreaseStock(List<CartDTO> cartDTOS) {
        List<Product> products = decreaseStockProcess(cartDTOS);
        List<ProductResp> productResps =products.stream().map(e -> {
            ProductResp productResp = new ProductResp();
            BeanUtils.copyProperties(e,productResp);
            return productResp;
        }).collect(Collectors.toList());

        rabbitTemplate.convertAndSend(Constant.ProductQueue.DECREASE, JsonUtil.toJsonString(productResps));
    }

    @Transactional
    public List<Product> decreaseStockProcess(List<CartDTO> cartDTOS) {
        List<Product> products = new ArrayList<>();
        for (CartDTO cartDTO : cartDTOS){
            Optional<Product> productOption = productRepository.findById(cartDTO.getId());
            if(!productOption.isPresent()){
                throw new ProductException(ProductError.PRODUCT_NOT_EXIST);
            }
            Product product = productOption.get();
            Integer result = product.getStock() - cartDTO.getQuantity();
            if(result < 0){
                throw new ProductException(ProductError.PRODUCT_STOCK_ERROR);
            }
            product.setStock(result);
            productRepository.save(product);
            products.add(product);
        }
        return  products;
    }


}

package com.morgan.product.service;

import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import com.morgan.product.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> findSaleAll();

    List<ProductResp> findList(List<Integer> ids);

    void decreaseStock(List<CartDTO> cartDTOS);

}

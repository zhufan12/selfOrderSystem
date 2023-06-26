package com.morgan.product.repository;

import com.morgan.product.entity.Product;
import com.morgan.product.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByStatus(ProductStatus status);

    List<Product> findByIdIn(List<Integer> ids);
}

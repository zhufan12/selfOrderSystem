package com.morgan.product.service;

import com.morgan.product.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findByTypeIn(List<Integer> types);
}

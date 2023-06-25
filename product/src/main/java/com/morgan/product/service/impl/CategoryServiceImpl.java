package com.morgan.product.service.impl;

import com.morgan.product.entity.Category;
import com.morgan.product.repository.CategoryRepository;
import com.morgan.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findByTypeIn(List<Integer> types) {
        return  categoryRepository.findByTypeIn(types);
    }
}

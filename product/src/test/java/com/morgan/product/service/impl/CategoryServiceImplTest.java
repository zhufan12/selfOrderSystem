package com.morgan.product.service.impl;

import com.morgan.product.entity.Category;
import com.morgan.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
public class CategoryServiceImplTest extends ProductServiceImplTest {


    @Autowired
    private CategoryService categoryService;

    @Test
    void findByTypeIn() {
        List<Category> categories = categoryService.findByTypeIn(Arrays.asList(11,22));
        assert  categories.size() > 0;
    }
}
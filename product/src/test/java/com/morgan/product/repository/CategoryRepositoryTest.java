package com.morgan.product.repository;

import com.morgan.product.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {


    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findByType() {
        List<Category> categories = categoryRepository.findByTypeIn(Arrays.asList(11,22));
        assert  categories.size() > 0;
    }
}
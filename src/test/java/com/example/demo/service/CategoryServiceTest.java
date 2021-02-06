package com.example.demo.service;

import com.example.demo.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTest
{
    @Autowired
    CategoryService categoryService;

    @Test
    public void givenInitialDataWhenFindCategoryByIdThenGetCorrectCategory()
    {
        Optional<Category> category = categoryService.getCategory("CH2_100001");

        Assertions.assertTrue(category.isPresent());
        Assertions.assertEquals("WC complete solutions",category.get().getName());
    }

    @Test
    public void givenInitialDataWhenGetAllCategoriesThenReturnAllCategories()
    {
        List<Category> allCategories = categoryService.getAllCategories();

        Assertions.assertEquals(10,allCategories.size());
    }
}

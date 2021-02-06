package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    Optional<Category> getCategory(String id);

    Optional<Category> getCategory(String id, int maxDepth);

    List<Category> getAllCategories();


}

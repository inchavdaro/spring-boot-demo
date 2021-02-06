package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository
{
    Optional<Category> getCategory();

    Category saveCategory(Category category);
}

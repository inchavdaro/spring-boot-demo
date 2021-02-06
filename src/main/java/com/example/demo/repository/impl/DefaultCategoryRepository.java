package com.example.demo.repository.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultCategoryRepository implements CategoryRepository
{
    private Category data;

    @Override
    public Optional<Category> getCategory()
    {
        return Optional.ofNullable(data);
    }

    @Override
    public Category saveCategory(Category category)
    {
        this.data = category;
        return category;
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DefaultCategoryService implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategory(String id)
    {
        Optional<Category> category = categoryRepository.getCategory();
        if (category.isPresent() && !category.get().getId().equals(id))
        {
            return iterateCategory(category.get(), id, 0, Integer.MAX_VALUE);
        }
        return category;
    }

    @Override
    public Optional<Category> getCategory(String id, int maxDepth)
    {
        Optional<Category> category = categoryRepository.getCategory();
        if (category.isPresent() && !category.get().getId().equals(id))
        {
            return iterateCategory(category.get(), id, 0, maxDepth);
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.getCategory()
                .map(category -> flatten(category).map(this::mapToCategoryWithNoChildren)
                        .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }

    private Optional<Category> iterateCategory(Category category, String id, int depth, int maxDepth)
    {
        if (depth > maxDepth)
        {
            return Optional.empty();
        }
        Optional<Category> optionalCategory = category.getSubCategories().stream()
                .filter(subCategory -> subCategory.getId().equals(id)).findFirst();

        if (optionalCategory.isPresent())
        {
            return optionalCategory;
        }

        for (Category subCategory : category.getSubCategories())
        {
            Optional<Category> subCategoryOpt = iterateCategory(subCategory, id, depth++, maxDepth);
            if (subCategoryOpt.isPresent())
            {
                return subCategoryOpt;
            }
        }
        return Optional.empty();
    }

    private Stream<Category> flatten(Category category)
    {
        return Stream.concat(Stream.of(category), category.getSubCategories().stream().flatMap(this::flatten));
    }

    private Category mapToCategoryWithNoChildren(Category category)
    {
        Category result = new Category();
        result.setId(category.getId());
        result.setName(category.getName());
        result.setSlogan(category.getSlogan());
        result.setImages(category.getImages());
        result.setOverviews(category.getOverviews());
        result.setSubCategories(Collections.emptySet());
        result.setHasProducts(category.HasProducts());
        result.setHasSpareParts(category.HasSpareParts());
        return result;
    }
}

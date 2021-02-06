package com.example.demo.model;

import com.example.demo.model.enums.CategoryType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

public class Category
{
    private String id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String slogan;

    private CategoryType categoryType;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Category> subCategories;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Image> images;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Overview> overviews;

    private boolean hasProducts;
    private boolean hasSpareParts;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSlogan()
    {
        return slogan;
    }

    public void setSlogan(String slogan)
    {
        this.slogan = slogan;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType)
    {
        this.categoryType = categoryType;
    }

    public Set<Category> getSubCategories()
    {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories)
    {
        this.subCategories = subCategories;
    }

    public Set<Image> getImages()
    {
        return images;
    }

    public void setImages(Set<Image> images)
    {
        this.images = images;
    }

    public Set<Overview> getOverviews()
    {
        return overviews;
    }

    public void setOverviews(Set<Overview> overviews)
    {
        this.overviews = overviews;
    }

    public boolean HasProducts()
    {
        return hasProducts;
    }

    public void setHasProducts(boolean hasProducts)
    {
        this.hasProducts = hasProducts;
    }

    public boolean HasSpareParts()
    {
        return hasSpareParts;
    }

    public void setHasSpareParts(boolean hasSpareParts)
    {
        this.hasSpareParts = hasSpareParts;
    }
}

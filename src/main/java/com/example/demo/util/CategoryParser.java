package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.Image;
import com.example.demo.model.Overview;
import com.example.demo.model.enums.CategoryType;
import com.example.demo.model.enums.Orientation;
import com.example.demo.repository.CategoryRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;


import static java.util.stream.Collectors.toSet;

@Component
public class CategoryParser
{
    @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    public void loadInitialData()
    {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("/home/ivan/Projects/demo/src/main/resources/categories.json"))
        {
            Object obj = parser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;

            categoryRepository.saveCategory(parseCategory(jsonObject));
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
    }

    private Category parseCategory(JSONObject jsonObject)
    {
        Category category = new Category();
        category.setId((String) jsonObject.get("id"));
        category.setName((String) jsonObject.get("name"));
        category.setSlogan((String) jsonObject.get("slogan"));
        category.setHasProducts((boolean) jsonObject.get("hasProducts"));
        category.setHasSpareParts((boolean) jsonObject.get("hasSpareParts"));
        category.setCategoryType(CategoryType.valueOf((String) jsonObject.get("categoryType")));
        if (jsonObject.containsKey("images"))
        {
            JSONArray images = (JSONArray) jsonObject.get("images");
            category.setImages((Set<Image>) images.stream().map(image -> parseImage((JSONObject) image)).collect(toSet()));
        }
        else
        {
            category.setImages(Collections.emptySet());
        }
        if(jsonObject.containsKey("overview"))
        {
            JSONArray overviews = (JSONArray) jsonObject.get("overview");
            category.setOverviews((Set<Overview>) overviews.stream().map(overview -> parseOverview((JSONObject) overview)).collect(toSet()));
        }
        else
        {
            category.setOverviews(Collections.emptySet());
        }
        if(jsonObject.containsKey("subCategories"))
        {
            JSONArray subCategories = (JSONArray) jsonObject.get("subCategories");
            category.setSubCategories((Set<Category>) subCategories.stream()
                    .map(subCategory -> parseCategory((JSONObject) subCategory)).collect(toSet()));
        }
        else
        {
            category.setSubCategories(Collections.emptySet());
        }
        return category;
    }

    private Image parseImage(JSONObject image)
    {
        Image result = new Image();
        result.setKey((String) image.get("key"));
        result.setThumbnail((String) image.get("thumbnail"));
        result.setOrientation(Orientation.valueOf((String) image.get("orientation")));
        return result;
    }

    private Overview parseOverview(JSONObject overview)
    {
        Overview result = new Overview();
        result.setName((String) overview.get("name"));
        result.setUrl((String) overview.get("url"));

        return result;
    }
}

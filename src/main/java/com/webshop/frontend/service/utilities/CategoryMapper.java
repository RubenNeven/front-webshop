package com.webshop.frontend.service.utilities;

import com.webshop.frontend.controller.dto.CategoryDto;
import com.webshop.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category map(CategoryDto categoryDto){
        return Category.builder()
                .category_id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }

    public CategoryDto map(Category category){
        return CategoryDto.builder()
                .id(category.getCategory_id())
                .name(category.getName())
                .build();
    }
}

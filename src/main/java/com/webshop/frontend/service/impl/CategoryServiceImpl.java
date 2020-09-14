package com.webshop.frontend.service.impl;

import com.webshop.frontend.controller.dto.CategoryDto;
import com.webshop.frontend.controller.dto.CategoryDtoList;
import com.webshop.frontend.service.CategoryService;
import com.webshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final RestTemplate template;

    @Autowired
    public CategoryServiceImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        ResponseEntity<CategoryDtoList> categoryDtoListResponseEntity = template.getForEntity("http://localhost:8081/api/categories", CategoryDtoList.class);
        CategoryDtoList categoryDtoList = categoryDtoListResponseEntity.getBody();
        List<CategoryDto> categories = categoryDtoList.getCategories();
        return categories;
    }
}

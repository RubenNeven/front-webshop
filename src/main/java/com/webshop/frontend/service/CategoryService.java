package com.webshop.frontend.service;

import com.webshop.frontend.controller.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAllCategories();
}

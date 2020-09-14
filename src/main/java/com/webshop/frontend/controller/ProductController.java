package com.webshop.frontend.controller;

import com.webshop.frontend.controller.dto.*;
import com.webshop.frontend.service.CategoryService;
import com.webshop.frontend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping()
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/products")
    public ResponseEntity<ProductDtoList> getProducts(){
         List<ProductDto> products = productService.findAllProducts();
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(new ProductDtoList(products));
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoryDtoList> getCategories(){
        List<CategoryDto> categories = categoryService.findAllCategories();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CategoryDtoList(categories));
    }
}

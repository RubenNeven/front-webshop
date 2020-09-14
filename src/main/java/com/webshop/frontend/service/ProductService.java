package com.webshop.frontend.service;

import com.webshop.frontend.controller.dto.ProductDto;
import com.webshop.model.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();
}

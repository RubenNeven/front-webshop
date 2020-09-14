package com.webshop.frontend.service.impl;

import com.webshop.frontend.controller.dto.ProductDto;
import com.webshop.frontend.controller.dto.ProductDtoList;
import com.webshop.frontend.controller.dto.ProductList;
import com.webshop.frontend.service.ProductService;
import com.webshop.frontend.service.utilities.ProductMapper;
import com.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(RestTemplate restTemplate, ProductMapper productMapper) {
        this.restTemplate = restTemplate;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        ResponseEntity<ProductDtoList> productDtoListResponseEntity = restTemplate.getForEntity("http://localhost:8081/api/products", ProductDtoList.class);
        ProductDtoList productList = productDtoListResponseEntity.getBody();
        List<ProductDto> productDtos = productList.getProducts();
        return productDtos;
    }

}

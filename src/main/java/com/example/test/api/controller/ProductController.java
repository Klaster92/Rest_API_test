package com.example.test.api.controller;

import com.example.test.api.model.Product;
import com.example.test.api.repository.ProductRepository;
import com.example.test.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository repository, ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
    }

}

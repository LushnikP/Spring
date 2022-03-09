package com.geekbrains.gbrestdemo.controllers;

import com.geekbrains.gbrestdemo.entities.Product;
import com.geekbrains.gbrestdemo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/**")
@RestController
public class ProductRestController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productsService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        //product.setId(0L);
        product = productsService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        product = productsService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public int deleteStudent(@PathVariable Long id) {
        productsService.delete(id);
        return HttpStatus.OK.value();
    }


}

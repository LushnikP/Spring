package com.lesson3.service;

import com.lesson3.entites.Product;
import com.lesson3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ProductService{
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProductById(int id){
        return productRepository.findById(id);
    }

    public ProductService(){

    }
}

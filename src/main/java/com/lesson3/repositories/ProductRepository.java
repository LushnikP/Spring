package com.lesson3.repositories;

import com.lesson3.entites.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {
    public Product findById(int id){
        Product product = new Product();
        product.setTitle("Orange " + id);
        product.setCost("Cost " + (10 * id) + " " + id);
        return product;
    }
}

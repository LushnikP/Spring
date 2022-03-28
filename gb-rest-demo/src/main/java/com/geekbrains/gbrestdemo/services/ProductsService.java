package com.geekbrains.gbrestdemo.services;

import com.geekbrains.gbrestdemo.entities.Product;
import com.geekbrains.gbrestdemo.repositories.interfaces.ProductsRepository;
import com.geekbrains.gbrestdemo.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsService() {

    }

    //get
    public Product getProductById(Long id){
        Optional<Product> product = productsRepository.findById(id);
        if(!product.isPresent()){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return product.get();
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productsRepository.findAll();
    }

//    //public void addProduct(Product p){
//        productsRepository.save(p);
//    }


    // post put
    public Product saveOrUpdate(Product product){
        return productsRepository.save(product);
    }

    //delete
    public void delete(Long id) {

        Optional<Product> product = productsRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product with id = " + id + " not found");
        }
        productsRepository.delete(product.get());
    }
}

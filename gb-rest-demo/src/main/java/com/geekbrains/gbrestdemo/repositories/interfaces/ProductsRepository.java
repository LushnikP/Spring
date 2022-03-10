package com.geekbrains.gbrestdemo.repositories.interfaces;

import com.geekbrains.gbrestdemo.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {

}
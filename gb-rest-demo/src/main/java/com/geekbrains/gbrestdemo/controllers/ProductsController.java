package com.geekbrains.gbrestdemo.controllers;


import com.geekbrains.gbrestdemo.entities.Product;
import com.geekbrains.gbrestdemo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/{id}")
    public String showProductsList(Model model, @PathVariable(value = "id") Long productId) {
        List<Product> oneProducts = new ArrayList<>();
        oneProducts.add(productsService.getAllProducts().get(productId.intValue()));

        model.addAttribute("productsList", oneProducts);
        return "products-list";
    }

    @RequestMapping("/list")
    public String showProductsList(Model model) {
        List<Product> allProducts = productsService.getAllProducts();
        model.addAttribute("productsList", allProducts);
        return "products-list";
    }

    @RequestMapping(path="/add", method= RequestMethod.GET)
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setTitle("Unknown");
        model.addAttribute("product", product);
        return "add-product-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/products/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long productId) {
        productsService.delete(productId);
        return "redirect:/products/list";
    }
}
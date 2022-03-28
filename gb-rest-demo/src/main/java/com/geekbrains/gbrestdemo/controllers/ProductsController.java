package com.geekbrains.gbrestdemo.controllers;


import com.geekbrains.gbrestdemo.entities.Product;
import com.geekbrains.gbrestdemo.entities.User;
import com.geekbrains.gbrestdemo.services.ProductsService;
import com.geekbrains.gbrestdemo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;
    private UserServiceImpl userService;

    private HashMap<String, Integer> cartProduct = new HashMap<>();

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }


    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
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

    @RequestMapping("/cart")
    public String showCart(Model model) {
        int total = 0;
        for(Map.Entry<String, Integer> entry : cartProduct.entrySet()){
            total += entry.getValue();
        }
        model.addAttribute("cartList", cartProduct);
        model.addAttribute("total", total);
        return "cart";
    }

    @RequestMapping(value = {"/add_to_cart/{id}"}, method = RequestMethod.GET)
    public String addToCart(@PathVariable(value = "id") Long productId, Model model) {
        Product product = productsService.getProductById(productId);

        int count = 1;
        if(cartProduct.containsKey(product.getTitle())){
            count++;
            Integer value = product.getPrice() * count;
            cartProduct.put(product.getTitle(), value);
        } else {
            cartProduct.put(product.getTitle(), product.getPrice());
        }
        return "redirect:/products/list";
    }

    @RequestMapping(path="/remove_from_cart/{key}", method=RequestMethod.GET)
    public String removeFromCart(@PathVariable(value = "key") String productName) {
        cartProduct.remove(productName);
        return "redirect:/products/cart";
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
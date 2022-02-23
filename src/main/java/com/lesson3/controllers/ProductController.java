package com.lesson3.controllers;

import com.lesson3.entites.Product;
import com.lesson3.entites.Products;
import com.lesson3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/show_product")
    public String hello(Model uiModel){
        Product[] products = new Product[2];
        products[0] = productService.getProductById(10);
        products[1] = productService.getProductById(20);

        Products productsList = new Products();
        productsList.setProducts(products);

        uiModel.addAttribute("products", productsList);
        return "products";
    }

    @RequestMapping(path = "/show_product_by_id", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(Model model, @RequestParam int id){
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping(path = "/show_product_by_id/{sid}", method =  RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("sid") int id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping(path = "/set_product_by_id", method = RequestMethod.POST)
    public void setProduct(@RequestBody Product product){
        System.out.println(product.getTitle() + " " + product.getCost());
    }

    @RequestMapping("/show_form")
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }
    @RequestMapping("/process_form")
    public String processForm(@ModelAttribute("product") Product product){
        return "product-form-result";
    }
}

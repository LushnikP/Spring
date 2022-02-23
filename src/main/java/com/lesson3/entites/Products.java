package com.lesson3.entites;

public class Products {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductsAsList(){
        return productList;
    }

    public void setProducts(Product[] products){
        productList.addAll(Arrays.asList(products));
    }
}

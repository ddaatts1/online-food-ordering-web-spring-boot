package com.ecomerce.onlinefoodordering.service;

import com.ecomerce.onlinefoodordering.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    Product getById(int productid);

    List<Product> getAllProduct();


    void updateProduct(Product product, int ProductId);

    void removeProduct(int ProductId);

    void freezeProduct(int ProductId);

    void openProduct(int ProductId);

    Product findByProductName(String productName);
}

package com.ecomerce.onlinefoodordering.service;

import com.ecomerce.onlinefoodordering.model.Category;
import com.ecomerce.onlinefoodordering.model.Category_Product;
import com.ecomerce.onlinefoodordering.model.Product;
import com.ecomerce.onlinefoodordering.repository.Category_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Category_ProductServiceImpl implements Category_ProductService{

    @Autowired
    Category_ProductRepository category_productRepository;

    @Override
    public void add(Category category, Product product){
        category_productRepository.save(new Category_Product(category,product));
    }
}

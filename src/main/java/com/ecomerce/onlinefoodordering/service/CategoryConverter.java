package com.ecomerce.onlinefoodordering.service;

import com.ecomerce.onlinefoodordering.model.Category;
import com.ecomerce.onlinefoodordering.model.Category_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryConverter implements Converter<String, Category_Product> {
    @Autowired
    CategoryService categoryService;

    @Override
    public Category_Product convert(String id) {
        System.out.println("convert "+ id);
        Category category = categoryService.getListCategory().stream().filter(c -> c.getId() == Integer.parseInt(id)).collect(Collectors.toList()).get(0);
        return new Category_Product(category);
    }
}

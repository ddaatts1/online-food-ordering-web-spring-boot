package com.ecomerce.onlinefoodordering.service;

import com.ecomerce.onlinefoodordering.model.Category;
import com.ecomerce.onlinefoodordering.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory(){
        return  categoryRepository.findAll();
    }

}

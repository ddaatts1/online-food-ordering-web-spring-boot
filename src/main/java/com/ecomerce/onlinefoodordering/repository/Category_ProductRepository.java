package com.ecomerce.onlinefoodordering.repository;

import com.ecomerce.onlinefoodordering.model.Category_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category_ProductRepository extends JpaRepository<Category_Product,Integer> {
}

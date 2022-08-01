package com.ecomerce.onlinefoodordering.repository;

import com.ecomerce.onlinefoodordering.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByProductName(String productName);
}

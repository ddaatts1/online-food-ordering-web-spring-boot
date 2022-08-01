package com.ecomerce.onlinefoodordering.repository;

import com.ecomerce.onlinefoodordering.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

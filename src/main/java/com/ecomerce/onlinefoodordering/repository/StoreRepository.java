package com.ecomerce.onlinefoodordering.repository;

import com.ecomerce.onlinefoodordering.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
}

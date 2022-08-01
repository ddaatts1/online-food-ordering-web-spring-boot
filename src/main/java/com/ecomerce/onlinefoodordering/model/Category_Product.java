package com.ecomerce.onlinefoodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tblcategoryproduct")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public Category_Product(Category category) {
        this.category = category;
    }

    public Category_Product(Category category, Product product) {
        this.category = category;
        this.product = product;
    }
}

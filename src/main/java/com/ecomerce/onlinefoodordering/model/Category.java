package com.ecomerce.onlinefoodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblcategory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int id;
    @Column(name = "category_name")
    String categoryName;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    List<Category_Product> categoryProducts;
}

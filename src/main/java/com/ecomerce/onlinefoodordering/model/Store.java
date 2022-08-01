package com.ecomerce.onlinefoodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tblstore")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    int id;
    @Column(name = "store_name")
    String storeName;
    @Column(name = "store_email")
    String storeEmail;
    @Column(name = "store_phone_number")
    String storePhoneNumber;
    @Column(name = "time_start")
    Timestamp timeStart;
    @Column(name = "time_end")
    Timestamp timeEnd;

    @OneToMany(mappedBy = "store")
    List<Product> productList;

}

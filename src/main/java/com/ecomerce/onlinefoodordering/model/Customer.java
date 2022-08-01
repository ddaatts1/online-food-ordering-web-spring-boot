package com.ecomerce.onlinefoodordering.model;

import com.ecomerce.onlinefoodordering.Enum.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tblcustomer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    int id;
    @Column(name = "customer_full_name")
    String customerFullName;
    @Column(name = "customer_email")
    String customerEmail;
    @Column(name = "customer_phone_number")
    String customerPhoneNumber;
    @Column(name = "customer_image")
    String customerImage;
    @Column(name = "customer_username")
    String customerUsername;
    @Column(name = "customer_password")
    String customerPassword;
    @Column(name = "account_status")
    AccountStatus accountStatus;
}

package com.ecomerce.onlinefoodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductForm {
    String productName;
    BigDecimal productPrice;

}

package com.ecomerce.onlinefoodordering.model;

import com.ecomerce.onlinefoodordering.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "tblproduct")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int id;
    @NotNull(message = "Tên sản phẩm không được bỏ trống")
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_status")
    ProductStatus productStatus;
    @NotNull(message = "Giá sản phẩm khoog được bỏ trống")
    @Column(name = "product_price")
    BigDecimal productPrice;
    @Column(name = "product_image")
    String productImage;

    public int getIntProductStatus(){
        if(productStatus == ProductStatus.Available)
            return 0;
        else return 1;
    }

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    List<Category_Product> category ;

}

package com.ecomerce.onlinefoodordering.service;

import com.ecomerce.onlinefoodordering.Enum.ProductStatus;
import com.ecomerce.onlinefoodordering.model.Product;
import com.ecomerce.onlinefoodordering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;


    @Override
    public void addProduct(Product product){
        productRepository.save(product);
    }
    @Override
    public Product getById(int productid){
        return productRepository.findById(productid).get();
    }

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    @Override
    public void updateProduct(Product product, int ProductId){
        Product editproduct = productRepository.findById(ProductId).get();
        editproduct.setProductPrice(product.getProductPrice());
        editproduct.setProductName(product.getProductName());
        productRepository.save(editproduct);

    }

    @Override
    public void removeProduct(int ProductId){
        Product product =productRepository.findById(ProductId).get();
        product.setProductStatus(ProductStatus.Deleted);
        productRepository.save(product);
    }
    @Override
    public void freezeProduct(int ProductId){
        Product product = productRepository.findById(ProductId).get();
        product.setProductStatus(ProductStatus.Sold_out);
        productRepository.save(product);
    }
    @Override
    public void openProduct(int ProductId){
        Product product = productRepository.findById(ProductId).get();
        product.setProductStatus(ProductStatus.Available);
        productRepository.save(product);
    }

    @Override
    public Product findByProductName(String productName){
        return  productRepository.findByProductName(productName);
    }

}

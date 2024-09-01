package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;


    // add product
    public Product addProduct(Product product) {
        System.out.println("Adding product: " + product);
        return productRepository.save(product);
    }

    //get Product
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //update product
    public Product updateProduct(Product product , int id) {
        Product updatedproduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        updatedproduct.setName(product.getName());
        updatedproduct.setDescription(product.getDescription());
        updatedproduct.setFeedBack(product.getFeedBack());
        updatedproduct.setPrice(product.getPrice());
        return productRepository.save(updatedproduct);
    }

    //delete product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

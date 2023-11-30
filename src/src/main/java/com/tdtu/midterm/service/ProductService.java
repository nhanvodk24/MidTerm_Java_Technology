package com.tdtu.midterm.service;

import com.tdtu.midterm.model.Product;
import com.tdtu.midterm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    public List<Product> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

    public List<Product> getProductsByFilter(
            String name,
            Double price) {
        return productRepository.findProductsByFilter(name, price);
    }

}

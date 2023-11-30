package com.tdtu.midterm.api;

import com.tdtu.midterm.dto.ProductDTO;
import com.tdtu.midterm.model.Product;
import com.tdtu.midterm.service.CategoryService;
import com.tdtu.midterm.service.OrderService;
import com.tdtu.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", ""})
    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        for (Product product: productService.getAllProduct()) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());
            productDTO.setImageName(product.getImageName());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }

    @PostMapping("/add")
    public List<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImageName(productDTO.getImageName());
        productService.addProduct(product);
        return getAllProduct();
    }

    @DeleteMapping("/{id}")
    public List<ProductDTO> deleteProduct(@PathVariable Long id) {
        productService.removeProductById(id);
        return getAllProduct();
    }

    @PutMapping("/{id}")
    public List<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productService.getProductById(id).get();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImageName(productDTO.getImageName());
        productService.addProduct(product);
        return getAllProduct();
    }
}

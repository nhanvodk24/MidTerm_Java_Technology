package com.tdtu.midterm.repository;

import com.tdtu.midterm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory_Id(int id);

    @Query("SELECT p FROM Product p WHERE (:name IS NULL OR p.name = :name) "
            + "AND (:price IS NULL OR p.price <= :price) ")
    List<Product> findProductsByFilter(
            @Param("name") String name,
            @Param("price") Double price);
}

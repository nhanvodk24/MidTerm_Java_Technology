package com.tdtu.midterm.repository;

import com.tdtu.midterm.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

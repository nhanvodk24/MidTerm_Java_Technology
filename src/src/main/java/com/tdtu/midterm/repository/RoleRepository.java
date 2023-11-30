package com.tdtu.midterm.repository;

import com.tdtu.midterm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

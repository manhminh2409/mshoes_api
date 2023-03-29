package com.mshoes.mshoesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
}

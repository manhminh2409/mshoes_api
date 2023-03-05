package com.mshoes.mshoesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

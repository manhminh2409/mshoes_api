package com.mshoes.mshoesApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(long categoryId);
}

package com.mshoes.mshoesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

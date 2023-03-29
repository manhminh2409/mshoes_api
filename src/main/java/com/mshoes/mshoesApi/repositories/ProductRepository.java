package com.mshoes.mshoesApi.repositories;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();
	List<Product> findByCategoryId(long categoryId);

	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.productVisited = p.productVisited + 1 WHERE p.id = :id")
	void incrementVisitedById(@Param("id") Long id);

}

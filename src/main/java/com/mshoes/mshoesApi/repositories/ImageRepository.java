package com.mshoes.mshoesApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	List<Image> findAll();
}

package com.mshoes.mshoesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

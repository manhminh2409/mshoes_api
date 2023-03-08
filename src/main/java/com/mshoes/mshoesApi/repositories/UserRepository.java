package com.mshoes.mshoesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshoes.mshoesApi.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserEmail(String userEmail);

	Optional<User> findByUserNameOrUserEmail(String userName, String userEmail);

	Optional<User> findByUserName(String userName);

	Boolean existsByUserName(String userName);

	Boolean existsByUserEmail(String userEmail);
}

package com.mshoes.mshoesApi.repositories;

import com.mshoes.mshoesApi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(String roleName);
}

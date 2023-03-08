package com.mshoes.mshoesApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mshoes.mshoesApi.models.DTO.UserDTO;
import com.mshoes.mshoesApi.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") long userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable(name = "id") long userId, @RequestBody UserDTO userDTO) {
		UserDTO responseUser = userService.updateUser(userDTO, userId);

		return new ResponseEntity<>(responseUser, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long userId) {
		try {
			userService.deleteUser(userId);

			return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Delete fail!!", HttpStatus.OK);
		}
	}
}

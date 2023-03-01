package com.mshoes.mshoesApi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userPassword;

	@Column
	private String userFullname;

	@Column
	private String userEmail;

	@Column
	private String userAddress;

	@Column
	private String userPhone;

	@Column(nullable = false)
	private String userCreatedDate;

	@Column
	private String userLastModified;

	@Column
	private int userRole;

	@Column
	private int userStatus;

}

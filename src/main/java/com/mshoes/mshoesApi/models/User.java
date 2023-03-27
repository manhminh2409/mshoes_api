package com.mshoes.mshoesApi.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }),
		@UniqueConstraint(columnNames = { "userEmail" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userPassword;

	@Column
	private String userFullname;

	@Column
	private String userEmail;

	@Column
	private String userImage;

	@Column
	private String userAddress;

	@Column
	private String userPhone;

	@Column(nullable = false)
	private String userCreatedDate;

	@Column
	private String userLastModified;

	@Column
	private int userStatus;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_role_id", referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails = new HashSet<>();

}

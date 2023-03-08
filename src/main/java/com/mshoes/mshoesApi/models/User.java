package com.mshoes.mshoesApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"userName"}),
		@UniqueConstraint(columnNames = {"userEmail"})
})
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
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "user_role_id",referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();

}

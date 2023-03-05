package com.mshoes.mshoesApi.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "USER")
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

	@OneToMany(mappedBy = "user")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude 
	private List<Product> products;

}

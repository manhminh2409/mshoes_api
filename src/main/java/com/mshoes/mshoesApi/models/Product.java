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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long id;

	@Column(nullable = false)
	private String productName;

	@Column
	private String productDescription;

	@Column
	private int productVisited;

	@Column(nullable = false)
	private String productCreatedDate;

	@Column
	private String productLastModified;

	@Column
	private int productStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id")
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Image> images = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_author_id")
	private User user;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductOption> productOptions = new HashSet<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductVariant> productVariants = new HashSet<>();
}

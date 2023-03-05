package com.mshoes.mshoesApi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Long productId;

	@Column(nullable = false)
	private String productName;

	@Column
	private String productDescription;

	@Column
	private int productVisited;

	@Column
	private int productTotal;

	@Column
	private int productSold;

	@Column
	private int productPrice;

	@Column
	private int productDiscountPrice;

	@Column(nullable = false)
	private String productCreatedDate;

	@Column
	private String productLastModified;

	@Column
	private int productStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_author_id")
	private User productUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id")
	private Category productCategory;

}

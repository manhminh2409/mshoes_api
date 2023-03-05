package com.mshoes.mshoesApi.models.DTO;

import com.mshoes.mshoesApi.models.User;

import lombok.Data;

@Data
public class ProductDTO {

	private Long productId;

	private String productName;

	private String productDescription;

	private int productVisited;

	private int productTotal;

	private int productSold;

	private int productPrice;

	private int productDiscountPrice;

	private String productCreatedDate;

	private String productLastModified;

	private int productStatus;

	private User user;
}

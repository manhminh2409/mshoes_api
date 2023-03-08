package com.mshoes.mshoesApi.models.DTO;

import com.mshoes.mshoesApi.models.Category;

import lombok.Data;

@Data
public class ProductDTO {

	private long id;

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

	private Category productCategory;
}

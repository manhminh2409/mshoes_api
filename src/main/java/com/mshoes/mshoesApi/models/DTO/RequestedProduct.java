package com.mshoes.mshoesApi.models.DTO;

import java.util.List;

import lombok.Data;

@Data
public class RequestedProduct {
	private String productName;

	private String productDescription;

	private int productVisited;

	private List<String> imageUrls;

	private int productStatus;

	private long categoryId;

	private long userId;
}

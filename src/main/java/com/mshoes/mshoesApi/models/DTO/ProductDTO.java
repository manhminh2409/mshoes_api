package com.mshoes.mshoesApi.models.DTO;

import com.mshoes.mshoesApi.models.*;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

	private long id;

	private String productName;

	private String productDescription;

	private int productVisited;

	private String productCreatedDate;

	private String productLastModified;

	private int productStatus;

	private String categoryTitle;

	private String authorFullname;

	private List<ImageDTO> images;

	private List<ProductOption> productOptions;

	private List<ProductVariant> productVariants;


}

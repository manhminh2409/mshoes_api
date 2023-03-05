package com.mshoes.mshoesApi.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private Long categoryId;

	private String categoryTitle;

	private String categoryDescription;

	private String categoryCreatedDate;

	private String categoryLastModified;

	private int categoryStatus;
}

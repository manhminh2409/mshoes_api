package com.mshoes.mshoesApi.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private long id;

	private String categoryTitle;

	private String categoryDescription;

	private String categoryCreatedDate;

	private String categoryLastModified;

	private int categoryStatus;

}

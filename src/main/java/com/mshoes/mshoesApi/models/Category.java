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

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@Column
	private String categoryTitle;

	@Column
	private String categoryDescription;

	@Column
	private String categoryCreatedDate;

	@Column
	private String categoryLastModified;

	@Column
	private int categoryStatus;

	@OneToMany(mappedBy = "productCategory")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Product> categoryProducts;
}

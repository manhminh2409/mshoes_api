package com.mshoes.mshoesApi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "INVENTORY")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private int total;

	@Column
	private int sold;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fk_vv_product_id", referencedColumnName = "productId"),
			@JoinColumn(name = "fk_vv_variant_id", referencedColumnName = "variantId"),
			@JoinColumn(name = "fk_vv_value_id", referencedColumnName = "valueId") })
	private VariantValue variantValue;
}

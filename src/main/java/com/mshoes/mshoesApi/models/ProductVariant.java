package com.mshoes.mshoesApi.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT_VARIANT")
public class ProductVariant {

	@EmbeddedId
	private ProductVariantId id;

	@Column
	private String skuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "variant_product_id")
	private Product product;

	@OneToMany(mappedBy = "productVariant", cascade = CascadeType.ALL)
	private Set<VariantValue> variantValues = new HashSet<>();

	@Embeddable
	public static class ProductVariantId implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long variantId;

		private long productId;

		public long getVariantId() {
			return variantId;
		}

		public void setVariantId(long variantId) {
			this.variantId = variantId;
		}

		public long getProductId() {
			return productId;
		}

		public void setProductId(long productId) {
			this.productId = productId;
		}
		
	}
}

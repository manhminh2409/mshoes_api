package com.mshoes.mshoesApi.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT_OPTION")
public class ProductOption {
	@EmbeddedId
	private ProductOptionId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "option")
	private Option option;

	@OneToMany(mappedBy = "productOption", cascade = CascadeType.ALL)
	private Set<VariantValue> variantValues = new HashSet<>();

	@Embeddable
	public static class ProductOptionId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private long optionId;

		private long productId;

		public long getOptionId() {
			return optionId;
		}

		public void setOptionId(long optionId) {
			this.optionId = optionId;
		}

		public long getProductId() {
			return productId;
		}

		public void setProductId(long productId) {
			this.productId = productId;
		}
		
	}
}

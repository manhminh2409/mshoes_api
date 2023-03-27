package com.mshoes.mshoesApi.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "VARIANT_VALUE")
public class VariantValue {

	@EmbeddedId
	private VariantValueId id;

	@Column
	private int price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fk_pv_variant_id", referencedColumnName = "variantId"),
			@JoinColumn(name = "fk_pv_product_id", referencedColumnName = "productId") })
	private ProductVariant productVariant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fk_ov_value_id", referencedColumnName = "valueId"),
			@JoinColumn(name = "fk_ov_option_id", referencedColumnName = "optionId") })
	private OptionValue optionValue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fk_po_option_id", referencedColumnName = "optionId"),
			@JoinColumn(name = "fk_po_product_id", referencedColumnName = "productId") })
	private ProductOption productOption;

	@OneToOne(mappedBy = "variantValue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private OrderItem orderItem;

	@OneToOne(mappedBy = "variantValue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Inventory inventory;

	@Embeddable
	public static class VariantValueId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private long productId;

		private long variantId;

		private long valueId;

		public long getProductId() {
			return productId;
		}

		public void setProductId(long productId) {
			this.productId = productId;
		}

		public long getVariantId() {
			return variantId;
		}

		public void setVariantId(long variantId) {
			this.variantId = variantId;
		}

		public long getValueId() {
			return valueId;
		}

		public void setValueId(long valueId) {
			this.valueId = valueId;
		}
		
		

	}
}

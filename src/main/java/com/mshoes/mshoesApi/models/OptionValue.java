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
@Table(name = "OPTION_VALUE")
public class OptionValue {

	@EmbeddedId
	private OptionValueId id;

	@Column
	private String optionValue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "option_value_id")
	private Option option;

	@OneToMany(mappedBy = "optionValue", cascade = CascadeType.ALL)
	private Set<VariantValue> variantValues = new HashSet<>();

	@Embeddable
	public static class OptionValueId implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long valueId;

		private long optionId;

		public long getValueId() {
			return valueId;
		}

		public void setValueId(long valueId) {
			this.valueId = valueId;
		}

		public long getOptionId() {
			return optionId;
		}

		public void setOptionId(long optionId) {
			this.optionId = optionId;
		}

		
	}
}

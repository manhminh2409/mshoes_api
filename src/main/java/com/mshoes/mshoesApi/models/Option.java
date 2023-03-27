package com.mshoes.mshoesApi.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "OPTION")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String optionName;

	@OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
	private Set<ProductOption> productOptions = new HashSet<>();

	@OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
	private Set<OptionValue> optionValues = new HashSet<>();
}

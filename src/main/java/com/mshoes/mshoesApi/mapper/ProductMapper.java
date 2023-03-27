package com.mshoes.mshoesApi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.models.Product;
import com.mshoes.mshoesApi.models.DTO.ProductDTO;

@Service
public class ProductMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/**
	 * Method convert Product to ProductDTO using ModelMapper <br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param product
	 * @return
	 */
	public ProductDTO toDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

	/**
	 * Method convert ProductDTO to Product using ModelMapper <br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param userDTO
	 * @return
	 */
	public Product toEntity(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return product;
	}
}

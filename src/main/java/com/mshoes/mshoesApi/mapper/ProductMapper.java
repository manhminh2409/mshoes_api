package com.mshoes.mshoesApi.mapper;

import com.mshoes.mshoesApi.models.DTO.ProductDTO;
import com.mshoes.mshoesApi.models.DTO.RequestedProduct;
import com.mshoes.mshoesApi.models.Image;
import com.mshoes.mshoesApi.models.Product;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {
	// mapper one model to dto
	@Mapping(target = "categoryTitle", source = "category.categoryTitle")
	@Mapping(target = "authorFullname", source = "user.userFullname")
	ProductDTO mapModelToDTO(Product product);

	// mapper list model to dto
	@Mapping(target = "categoryTitle", source = "category.categoryTitle")
	@Mapping(target = "authorFullname", source = "user.userFullname")
	List<ProductDTO> mapModelToDTOs(List<Product> products);

	// mapper one dto to model
	Product mapDTOToModel(ProductDTO productDTO);

	// mapper list dto to model
	List<Product> mapDTOToModels(List<ProductDTO> productDTOS);

	@Mapping(target = "category.id", source = "categoryId")
	@Mapping(target = "user.id", source = "userId")
	@Mapping(target = "images", source = "imageUrls", qualifiedByName = "mapUrlsToImages")
	Product mapRequestedToModel(RequestedProduct requestedProduct);

	@Named("mapUrlsToImages")
	default List<Image> mapUrlsToImages(List<String> imageUrls) {
		if (imageUrls == null) {
			return new ArrayList<>();
		}
		return imageUrls.stream().map(Image::new).collect(Collectors.toList());
	}

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "category.id", source = "categoryId")
	@Mapping(target = "user.id", source = "userId")
	void updateModel(@MappingTarget Product product, RequestedProduct requestedProduct);
}

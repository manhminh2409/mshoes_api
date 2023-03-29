package com.mshoes.mshoesApi.mapper;

import com.mshoes.mshoesApi.models.DTO.ImageDTO;
import com.mshoes.mshoesApi.models.DTO.RequestedImage;
import com.mshoes.mshoesApi.models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ImageMapper {

	// map one model to dto
	@Mapping(target = "imageUrl", source = "image.imageUrl")
	ImageDTO mapModelToDTO(Image image);

	// map list model to dto
	@Mapping(target = "imageUrl", source = "image.imageUrl")
	List<ImageDTO> mapModelToDTOs(List<Image> images);

	// mapper one dto to model
	Image mapDTOToModel(ImageDTO imageDTO);

	// map list dto to model
	List<Image> mapDTOToModels(List<ImageDTO> imageDTOS);

	@Mapping(target = "product.id", source = "productId")
	Image mapRequestedToModel(RequestedImage requestedImage);
}

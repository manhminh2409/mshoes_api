package com.mshoes.mshoesApi.services;

import java.util.List;

import com.mshoes.mshoesApi.models.DTO.ProductDTO;

public interface ProductService {

	/**
	 * Method get all product is enable(product_status=1) in database <br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @return
	 */
	List<ProductDTO> getAllProducts();

	/**
	 * Method get all product is enable(product_status=1) by category in database
	 * <br>
	 * <u><i>Update: 06/03/2023</i></u>
	 *
	 * @return
	 */
	List<ProductDTO> getProductsByCategoryId(Long categoryId);

	/**
	 * Method get a product by product_id in database <br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param productID
	 * @return
	 */
	ProductDTO getProductById(Long productID);

	/**
	 * Method create new product<br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param productDTO
	 * @return
	 */
	ProductDTO createProduct(ProductDTO productDTO);

	/**
	 * Method update detail a product with new infomation and product_id<br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param productDTO
	 * @param productId
	 * @return
	 */
	ProductDTO updateProduct(ProductDTO productDTO, long productId);

	/**
	 * Method delete (change product_status to value 0) change enable product to
	 * disable product<br>
	 * <u><i>Update: 02/03/2023</i></u>
	 *
	 * @param productId
	 * @return
	 */
	void deleteProductById(long productId);
}

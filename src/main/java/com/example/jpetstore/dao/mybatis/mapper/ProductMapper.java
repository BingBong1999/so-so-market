package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.Product;

public interface ProductMapper {

	List<Product> getProductListByCategory(int categoryId);

	List<Product> getProductListByUser(String accountId);

	List<Product> searchProductList(String keywords);

	List<Product> getAllProductList();

	Product getProduct(int productId);

	List<Product> getProductByUserAndTitle(@Param("accountId") String accountId, @Param("title") String title);

	void updateProduct(Product product);

	void insertProduct(Product product);

	void deleteProduct(int productId);

	void updateProductStatus(Product product);

}
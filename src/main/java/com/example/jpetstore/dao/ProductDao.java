package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Product;

public interface ProductDao {

	List<Product> getProductListByCategory(int categoryId) throws DataAccessException;

	List<Product> getProductListByUser(String accountId) throws DataAccessException;

	List<Product> searchProductList(String keywords) throws DataAccessException;

	List<Product> getAllProductList() throws DataAccessException;

	Product getProduct(int productId) throws DataAccessException;

	List<Product> getProductByUserAndTitle(String accountId, String title) throws DataAccessException;

	void updateProduct(Product product) throws DataAccessException;

	void insertProduct(Product product) throws DataAccessException;

	void deleteProduct(int productId) throws DataAccessException;

	void updateProductStatus(Product product) throws DataAccessException;

}

/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
	
	Product getProductByUserAndTitle(@Param("accountId") String accountId, @Param("title") String title);

	void updateProduct(Product product);

	void insertProduct(Product product);

	void deleteProduct(int productId);

	void updateProductStatus(Product product);

}
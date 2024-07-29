package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Category;

public interface CategoryMapper {

	List<Category> getCategoryList();

	Category getCategory(int categoryId);

}
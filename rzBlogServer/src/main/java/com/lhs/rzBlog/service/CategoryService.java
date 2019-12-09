package com.lhs.rzBlog.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhs.rzBlog.bean.Category;
import com.lhs.rzBlog.mapper.CategoryMapper;

/**
 * Created by uno in Dec. 6, 2019
 */
@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> getAllCategories() {
		return categoryMapper.getAllCategories();
	}
	
	public boolean deleteCategoryByIds(String ids) {
		String[] split = ids.split(",");
		int result = categoryMapper.deleteCategoryByIds(split);
		return result == split.length;
	}
	
	public int updateCateogyrById(Category category) {
		return categoryMapper.updateCategoryById(category);
	}
	
	public int addCategory(Category category) {
		category.setDate(new Timestamp(System.currentTimeMillis()));
		return categoryMapper.addCategory(category);
	}
}

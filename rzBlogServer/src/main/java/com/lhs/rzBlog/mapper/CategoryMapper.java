package com.lhs.rzBlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lhs.rzBlog.bean.Category;

/**
 * Created by Yiran in Dec. 6, 2019
 */
@Mapper
public interface CategoryMapper {
	List<Category> getAllCategories();
	
	int deleteCategoryByIds(@Param("ids") String[] ids);
	
	int updateCategoryById(Category category);
	
	int addCategory(Category category);
}

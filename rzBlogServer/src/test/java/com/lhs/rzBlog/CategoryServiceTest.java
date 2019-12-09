package com.lhs.rzBlog;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lhs.rzBlog.bean.Category;
import com.lhs.rzBlog.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

	@Autowired
	CategoryService categoryService;
	
	@Test
	public void test() {
		List<Category> list = categoryService.getAllCategories();
		for (Category category : list) {
			System.out.println(category.toString());
		}
	}

}

package com.lhs.rzBlog.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lhs.rzBlog.bean.Article;

/**
 * Created by Yiran in Dec. 15, 2019
 */

@Mapper
public interface ArticleMapper {
	int addNewArticle(Article article);
	
	int updateArticle(Article article);
}

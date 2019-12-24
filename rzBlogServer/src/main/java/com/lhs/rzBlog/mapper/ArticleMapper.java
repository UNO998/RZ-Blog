package com.lhs.rzBlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lhs.rzBlog.bean.Article;

/**
 * Created by Yiran in Dec. 15, 2019
 */

@Mapper
public interface ArticleMapper {
	int addNewArticle(Article article);
	
	int updateArticle(Article article);
	
	List<Article> getArticleByState(
			@Param("state") Integer state, @Param("start") Integer start,
			@Param("count") Integer count, @Param("uid") Long uid,
			@Param("keywords") String keywords);
	
	int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);
	
	int updateArticleState(@Param("aids") Long aids[], @Param("state") Integer state);
	
}

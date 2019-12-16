package com.lhs.rzBlog;

import java.sql.Timestamp;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lhs.rzBlog.bean.Article;
import com.lhs.rzBlog.mapper.ArticleMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {

	@Autowired
	ArticleMapper mapper;
	
	@Test
	public void testAddNewArticle() {
		Article article = Article.builder()
										.title("test")
										.mdContent("testMdContent")
										.htmlContent("testHtmlContent")
										.summary("testSummary")
										.cid(1L)
										.uid(1L)
										.publishDate(new Timestamp(System.currentTimeMillis()))
										.state(3)
										.pageView(3)
										.editTime(new Timestamp(System.currentTimeMillis()))
										.dynamicTags(new String[] {"youtube"})
										.nickname("testNickName")
										.cateName("testCateName")
//										.tags(Arrays.asList({new Tag()}))
										.stateStr("testSateStr")
										.build();
		Assert.assertEquals(1, mapper.addNewArticle(article));
	}
	
	@Test
	public void testUpdateArticle() {
		Article article = Article.builder()
										.id(108L)
										.title("test")
										.mdContent("testMdContent")
										.htmlContent("testHtmlContent")
										.summary("testSummary")
										.cid(1L)
										.uid(1L)
										.publishDate(new Timestamp(System.currentTimeMillis()))
										.state(3)
										.pageView(3)
										.editTime(new Timestamp(System.currentTimeMillis()))
										.dynamicTags(new String[] {"youtube"})
										.nickname("testNickName")
										.cateName("testCateName")
//										.tags(Arrays.asList({new Tag()}))
										.stateStr("testSateStr")
										.build();
		Assert.assertEquals(1, mapper.updateArticle(article));
	}

}

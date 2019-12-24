package com.lhs.rzBlog;

import java.sql.Timestamp;
import java.util.List;

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
										.id(111L)
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
	
	@Test
	public void testGetArticleByState() {
		List<Article> articleList = mapper.getArticleByState(1, 1, 2, 7L, "学习资料");
		
		for (Article a : articleList) {
			System.out.println(a);
		}
		
		Assert.assertEquals(1, articleList.size());
	}
	
	@Test
	public void testGetArticleCountByState() {
		Integer state = 1;
		Long uid = 6L;
		String keywords = "Linux ";
		int articleCount = mapper.getArticleCountByState(state, uid, keywords);
		
		Assert.assertEquals(1, articleCount);
	}
	
	@Test
	public void testUpdateArticleState() {
		Long[] aids = {110L};
		Assert.assertEquals(1, mapper.updateArticleState(aids, 2));
	}
	
	@Test
	public void testUpdateArticleStateById() {
		Assert.assertEquals(1, mapper.updateArticleStateById(110L, 1));
	}
	
	@Test
	public void testDeleteArticleById() {
		Long[] aids = {113L};
		Assert.assertEquals(1, mapper.deleteArticleById(aids));
	}
	
	@Test 
	public void testGetArticleById() {
		Article article = mapper.getArticleById(116L);
		Assert.assertEquals("SpringBoot+SpringSecurity处理Ajax登录请求", article.getTitle());
	}

}

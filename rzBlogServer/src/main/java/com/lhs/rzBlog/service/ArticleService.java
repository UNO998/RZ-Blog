package com.lhs.rzBlog.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhs.rzBlog.bean.Article;
import com.lhs.rzBlog.mapper.ArticleMapper;
import com.lhs.rzBlog.mapper.TagMapper;
import com.lhs.rzBlog.utils.Util;

/**
 * Created by Yiran in Dec. 26, 2019
 */

@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TagMapper tagsMapper;
    
    public int addNewArticle(Article article) {
    	// parse article summary
    	if (article.getSummary() == null || "".equals(article.getSummary())) {
    		// strip htmlContent as summary
    		String stripHtml = stripHtml(article.getHtmlContent());	
    		article.setSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
    	}
    	
		// adding publishDate, editTime, userId, dynamicTags
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		if (article.getState() == 1) {
			// set up publish date
			article.setPublishDate(timestamp);
		}
		article.setEditTime(timestamp);
		
		int aid = 0;
		
    	if (article.getId() == -1) {
    		// set up current userId
    		article.setUid(Util.getCurrentUser().getId());
    		aid = articleMapper.addNewArticle(article);
    	} else {
            aid = articleMapper.updateArticle(article);
    	}
    	
		// add tags
		String[] dynamicTags = article.getDynamicTags();
		if (dynamicTags != null && dynamicTags.length > 0) {
			int tags = addTagsToArticle(dynamicTags, article.getId());
			if (tags == -1) {
				return tags;
			}
		}
		return aid;
    }
    
    public List<Article> getArticleByState(Integer state, Integer page, Integer count,String keywords) {
        int start = (page - 1) * count;
        Long uid = Util.getCurrentUser().getId();
        return articleMapper.getArticleByState(state, start, count, uid, keywords);
    }
    
    public int getArticleCountByState(Integer state, Long uid,String keywords) {
        return articleMapper.getArticleCountByState(state, uid,keywords);
    }
    
    public int updateArticleState(Long[] aids, Integer state) {
        if (state == 2) {
            return articleMapper.deleteArticleById(aids);
        } else {
            return articleMapper.updateArticleState(aids, 2); // put into Recycled
        }
    }
    
    public int restoreArticle(Long articleId) {
        return articleMapper.updateArticleStateById(articleId, 1); // restore from recycled
    }

    public Article getArticleById(Long aid) {
        Article article = articleMapper.getArticleById(aid);
        articleMapper.pvIncrement(aid);
        return article;
    }

    public void pvStatisticsPerDay() {
        articleMapper.pvStatisticsPerDay();
    }
    
    /**
     * 获取最近七天的日期
     * @return
     */
    public List<String> getCategories() {
        return articleMapper.getCategories(Util.getCurrentUser().getId());
    }

    /**
     * 获取最近七天的数据
     * @return
     */
    public List<Integer> getDataStatistics() {
        return articleMapper.getDataStatistics(Util.getCurrentUser().getId());
    }
    
//    -------------------------------------------------------------------------------------------------
    
    private int addTagsToArticle(String[] dynamicTags, Long aid) {
        //1.delete all tags of article
        tagsMapper.deleteTagsByAid(aid);
        //2.adding new dynamicTags to database
        tagsMapper.saveTags(dynamicTags);
        //3.query tid of saved tags
        List<Long> tIds = tagsMapper.getTagsByTagNames(dynamicTags);
        //4.reset the tags of article
        int i = tagsMapper.saveTagsToArticleTags(tIds, aid);
        return i == dynamicTags.length ? i : -1;
    }
    
    private String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }
}

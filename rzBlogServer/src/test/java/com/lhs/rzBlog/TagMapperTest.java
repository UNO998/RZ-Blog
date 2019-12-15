package com.lhs.rzBlog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lhs.rzBlog.mapper.TagMapper;

/**
 * Created by Yiran in Dec. 11, 2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {

	@Autowired
	TagMapper mapper;
	
	@Test
	public void testSaveTags() {
		String[] tags = {"Youtube", "FaceBook"};
		mapper.saveTags(tags);
		
		List<Long> tagsId = mapper.getTagsByTagNames(tags);
		Assert.assertEquals(tagsId.size(), 2);
	}
	
	@Test
	public void testGetTagsByTagNames() {
		String[] tagNames = {"Linux", "666"};
		List<Long> tagsList = mapper.getTagsByTagNames(tagNames);
		
		Assert.assertEquals(tagsList.size(), 2);
	}
	
	@Test 
	public void testDeleteTagsByAid() {
		Long aid = 116L;
		
		int delete = mapper.deleteTagsByAid(aid);
		
		Assert.assertEquals(delete, 3);
	}
	
	@Test
	public void testSaveTagsToArticleTags() {
		List<Long> tagIds = new ArrayList<>();
		tagIds.add(35L);
		tagIds.add(66L);
		tagIds.add(36L);
		
		Long aid = 121L;
		
		int num = mapper.saveTagsToArticleTags(tagIds, aid);
		
		Assert.assertEquals(num, 3);
	}

	@Test
	public void testTagMapper() {
		/*
		 * Add Tags to tags table
		 * Function: saveTags()
		 */
		String[] tags = {"Youtube", "FaceBook"};
		Long aid = 121L;
		Assert.assertEquals(mapper.saveTags(tags), 2);
		
		/*
		 * Get tags by TagsNames
		 * Function: getTagsByTagNames()
		 */
		List<Long> tagsId = mapper.getTagsByTagNames(tags);
		Assert.assertEquals(tagsId.size(), 2);
		
		/*
		 * Add tags article relationship in article_tags table
		 * Function: saveTagsToArticleTags()
		 */
		Assert.assertEquals(
				mapper.saveTagsToArticleTags(tagsId, aid), 2);
		/*
		 * Delete tags article relationship in article_tags table
		 * Function: deleteTagsByAid()
		 */	
		Assert.assertEquals(
				mapper.deleteTagsByAid(aid), 2);
		
		/*
		 * Delete tags from tags table
		 * Function: deleteTagsByTid()
		 */
		for (Long id : tagsId) {
			Assert.assertEquals(
					mapper.deleteTagsByTid(id), 1);
		}
		
		
	}

}

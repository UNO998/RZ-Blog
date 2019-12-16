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
		Assert.assertEquals(2, tagsId.size());
	}
	
	@Test
	public void testGetTagsByTagNames() {
		String[] tagNames = {"Linux", "666"};
		List<Long> tagsList = mapper.getTagsByTagNames(tagNames);
		
		Assert.assertEquals(2, tagsList.size());
	}
	
	@Test 
	public void testDeleteTagsByAid() {
		Long aid = 116L;
		
		int delete = mapper.deleteTagsByAid(aid);
		
		Assert.assertEquals(3, delete);
	}
	
	@Test
	public void testSaveTagsToArticleTags() {
		List<Long> tagIds = new ArrayList<>();
		tagIds.add(35L);
		tagIds.add(66L);
		tagIds.add(36L);
		
		Long aid = 121L;
		
		int num = mapper.saveTagsToArticleTags(tagIds, aid);
		
		Assert.assertEquals(3, num);
	}

	@Test
	public void testTagMapper() {
		/*
		 * Add Tags to tags table
		 * Function: saveTags()
		 */
		String[] tags = {"Youtube", "FaceBook"};
		Long aid = 121L;
		Assert.assertEquals(2, mapper.saveTags(tags));
		
		/*
		 * Get tags by TagsNames
		 * Function: getTagsByTagNames()
		 */
		List<Long> tagsId = mapper.getTagsByTagNames(tags);
		Assert.assertEquals(2, tagsId.size());
		
		/*
		 * Add tags article relationship in article_tags table
		 * Function: saveTagsToArticleTags()
		 */
		Assert.assertEquals(
				2, mapper.saveTagsToArticleTags( tagsId, aid));
		/*
		 * Delete tags article relationship in article_tags table
		 * Function: deleteTagsByAid()
		 */	
		Assert.assertEquals(
				2, mapper.deleteTagsByAid(aid));
		
		/*
		 * Delete tags from tags table
		 * Function: deleteTagsByTid()
		 */
		for (Long id : tagsId) {
			Assert.assertEquals(
					1, mapper.deleteTagsByTid(id));
		}
		
		
	}

}

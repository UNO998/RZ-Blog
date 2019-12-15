package com.lhs.rzBlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Yiran in Dec. 11, 2019
 */

@Mapper
public interface TagMapper {
	
	int deleteTagsByAid(Long aid);
	
	int saveTags(@Param("tags") String[] tags);
	
	List<Long> getTagsByTagNames(@Param("tagNames") String[] tagNames);
	
	int saveTagsToArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);
}

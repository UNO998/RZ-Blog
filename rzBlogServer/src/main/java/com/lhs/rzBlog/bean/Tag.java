package com.lhs.rzBlog.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yiran in Dec. 11, 2019
 */

@Getter
@Setter
@EqualsAndHashCode
public class Tag {
	private Long id;
	private String tagName;
	
	public Tag() {
		
	}
	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + "]";
	}
	
	
}

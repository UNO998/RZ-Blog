package com.lhs.rzBlog.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.lhs.rzBlog.bean.User;

/**
 * Created by Yiran in Dec. 26, 2019
 */
public class Util {
	public static User getCurrentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}

}

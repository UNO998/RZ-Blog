package com.lhs.rzBlog.bean;

import java.sql.Timestamp;

/**
 * 
 * Created by Yiran on 2019/12/06
 *
 */
public class Category {
	private long id;
	private String cateName;
	private Timestamp date;
	
	public Category() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCateName() {
		return cateName;
	}
	
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cateName=" + cateName + ", date=" + date + "]";
	}
	
	
}

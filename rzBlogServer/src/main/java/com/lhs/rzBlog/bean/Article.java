package com.lhs.rzBlog.bean;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yiran in Dec. 15, 2019
 */

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Article {
	private Long id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private String summary;
    private Long cid;
    private Long uid;
    private Timestamp publishDate;
    private Integer state;
    private Integer pageView;
    private Timestamp editTime;
    private String[] dynamicTags;
    private String nickname;
    private String cateName;
    private List<Tag> tags;
    private String stateStr;
    
    public Article() {}
    
	public Article(Long id, String title, String mdContent, String htmlContent, String summary, Long cid, Long uid,
			Timestamp publishDate, Integer state, Integer pageView, Timestamp editTime, String[] dynamicTags,
			String nickname, String cateName, List<Tag> tags, String stateStr) {
		super();
		this.id = id;
		this.title = title;
		this.mdContent = mdContent;
		this.htmlContent = htmlContent;
		this.summary = summary;
		this.cid = cid;
		this.uid = uid;
		this.publishDate = publishDate;
		this.state = state;
		this.pageView = pageView;
		this.editTime = editTime;
		this.dynamicTags = dynamicTags;
		this.nickname = nickname;
		this.cateName = cateName;
		this.tags = tags;
		this.stateStr = stateStr;
	}
    
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", mdContent=" + mdContent + ", htmlContent=" + htmlContent
				+ ", summary=" + summary + ", cid=" + cid + ", uid=" + uid + ", publishDate=" + publishDate + ", state="
				+ state + ", pageView=" + pageView + ", editTime=" + editTime + ", dynamicTags="
				+ Arrays.toString(dynamicTags) + ", nickname=" + nickname + ", cateName=" + cateName + ", tags=" + tags
				+ ", stateStr=" + stateStr + "]";
	}




	
    
    
}

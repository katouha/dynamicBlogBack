package com.example.dynamicBlog.requestDto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBlogReqDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("blogKbn")
	private String blogKbn;
	
	@JsonProperty("apiFlg")
	private Boolean apiFlg;
	
	@JsonProperty("blogSeq")
	private Long blogSeq;
	
	@JsonProperty("blogList")
	private BlogInfo blogList;

	public static class BlogInfo{
		
		@JsonProperty("subTitle")
		private String subTitle;
		
		@JsonProperty("body")
		private String body;
		
		@JsonProperty("imageName")
		private String imageName;
	
		public String getSubTitle() {
			return subTitle;
		}
	
		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}
		public String getBody() {
			return body;
		}
	
		public void setBody(String body) {
			this.body = body;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}
		
	}

	

	public BlogInfo getBlogList() {
		return blogList;
	}

	public void setBlogList(BlogInfo blogList) {
		this.blogList = blogList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlogKbn() {
		return blogKbn;
	}

	public void setBlogKbn(String blogKbn) {
		this.blogKbn = blogKbn;
	}

	public Boolean getApiFlg() {
		return apiFlg;
	}

	public void setApiFlg(Boolean apiFlg) {
		this.apiFlg = apiFlg;
	}

	public Long getBlogSeq() {
		return blogSeq;
	}

	public void setBlogSeq(Long blogSeq) {
		this.blogSeq = blogSeq;
	}
	
}

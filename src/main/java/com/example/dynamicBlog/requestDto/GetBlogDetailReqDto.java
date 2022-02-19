package com.example.dynamicBlog.requestDto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBlogDetailReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("blogId")
	private Long blogId;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	
}

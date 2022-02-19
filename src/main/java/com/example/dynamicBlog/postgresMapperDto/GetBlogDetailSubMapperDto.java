package com.example.dynamicBlog.postgresMapperDto;

public class GetBlogDetailSubMapperDto {
	private String blogsubtitle;
	private String blogbody;
	private Long imageid;
	
	public String getBlogsubtitle() {
		return blogsubtitle;
	}
	public void setBlogsubtitle(String blogsubtitle) {
		this.blogsubtitle = blogsubtitle;
	}
	public String getBlogbody() {
		return blogbody;
	}
	public void setBlogbody(String blogbody) {
		this.blogbody = blogbody;
	}
	public Long getImageid() {
		return imageid;
	}
	public void setImageid(Long imageid) {
		this.imageid = imageid;
	}
	
	
}

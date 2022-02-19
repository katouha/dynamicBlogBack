package com.example.dynamicBlog.postgresMapperDto;

public class GetBlogDetailMapperDto {
	private String blogtitle;
	private String blogdiscription;
	private String registusername;
	private String registdate;
	private boolean delflg;
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getBlogdiscription() {
		return blogdiscription;
	}
	public void setBlogdiscription(String blogdiscription) {
		this.blogdiscription = blogdiscription;
	}
	public String getRegistusername() {
		return registusername;
	}
	public void setRegistusername(String registusername) {
		this.registusername = registusername;
	}
	public String getRegistdate() {
		return registdate;
	}
	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}
	public boolean isDelflg() {
		return delflg;
	}
	public void setDelflg(boolean delflg) {
		this.delflg = delflg;
	}
	
}

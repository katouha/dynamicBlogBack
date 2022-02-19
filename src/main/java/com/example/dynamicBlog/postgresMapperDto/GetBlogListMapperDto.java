package com.example.dynamicBlog.postgresMapperDto;

import java.sql.Date;

public class GetBlogListMapperDto {
	private String blogid;
	private String blogtitle;
	private String blogdiscription;
	private String registusername;
	private Date registDate;
	private boolean delflg;
	
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
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
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public boolean isDelflg() {
		return delflg;
	}
	public void setDelflg(boolean delflg) {
		this.delflg = delflg;
	}
	
	
}

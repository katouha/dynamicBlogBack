package com.example.dynamicBlog.postgresMapperDto;

import java.sql.Date;

public class GetBlogKbnMapperDto {
	private String blogkbn;
	private String kbnname;
	private String kbndiscription;
	private boolean delflg;
	private Date registdate;
	public String getBlogkbn() {
		return blogkbn;
	}
	public void setBlogkbn(String blogkbn) {
		this.blogkbn = blogkbn;
	}
	public String getKbnname() {
		return kbnname;
	}
	public void setKbnname(String kbnname) {
		this.kbnname = kbnname;
	}
	public boolean isDelflg() {
		return delflg;
	}
	public void setDelflg(boolean delflg) {
		this.delflg = delflg;
	}
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	public String getKbndiscription() {
		return kbndiscription;
	}
	public void setKbndiscription(String kbndiscription) {
		this.kbndiscription = kbndiscription;
	}
	
	
}

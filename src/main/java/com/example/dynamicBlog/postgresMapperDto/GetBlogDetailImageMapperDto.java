package com.example.dynamicBlog.postgresMapperDto;

public class GetBlogDetailImageMapperDto {
	private String imagepath;
	private String imagename;
	private boolean delflg;
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public boolean isDelflg() {
		return delflg;
	}
	public void setDelflg(boolean delflg) {
		this.delflg = delflg;
	}
	
}

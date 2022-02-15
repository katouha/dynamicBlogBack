package com.example.dynamicBlog.impl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CreateBlogImpl {
	@Insert("INSERT INTO m_blog_info (blogid, blogtitle, blogkbn,registusername,delflg) VALUES (#{blogid}, #{blogtitle}, #{blogkbn}, #{registusername}, #{delflg})")
	void setBlogInfo(@Param("blogid") Long blogid,@Param("blogtitle")String blogtitle, @Param("blogkbn")String blogkbn,@Param("registusername")String registusername,@Param("delflg")Boolean delflg);
	
	@Insert("INSERT INTO m_image (imageid, imagepath, imagename,delflg) VALUES (#{imageid}, #{imagepath}, #{imagename}, #{delflg})")
	void setImageInfo(@Param("imageid") Long imageid,@Param("imagepath")String imagepath, @Param("imagename")String imagename,@Param("delflg")Boolean delflg);
	
	@Insert("INSERT INTO t_blog_detail (blogid, blogsubtitle, blogbody,imageid) VALUES (#{blogid}, #{blogsubtitle}, #{blogbody}, #{imageid})")
	void setBlogDetailInfo(@Param("blogid") Long blogid,@Param("blogsubtitle")String blogsubtitle, @Param("blogbody")String blogbody,@Param("imageid")Long imageid);
	
	@Insert("INSERT INTO t_blog_detail (blogid, blogsubtitle, blogbody) VALUES (#{blogid}, #{blogsubtitle}, #{blogbody})")
	void setBlogDetailInfo2(@Param("blogid") Long blogid,@Param("blogsubtitle")String blogsubtitle, @Param("blogbody")String blogbody);
	
	@Select("SELECT nextval('blog_seq')")
	Long getBlogSeq();
	
	@Select("SELECT nextval('image_seq')")
	Long getImageSeq();
}

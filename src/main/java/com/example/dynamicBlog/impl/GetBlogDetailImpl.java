package com.example.dynamicBlog.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailImageMapperDto;
import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailMapperDto;
import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailSubMapperDto;

@Mapper
public interface GetBlogDetailImpl {
	@Select("SELECT blogtitle,blogdiscription,registusername,registdate,delflg FROM m_blog_info WHERE blogid= #{blogid}")
	GetBlogDetailMapperDto getBlogTitle(@Param("blogid") Long blogid);
	
	
	@Select("SELECT blogsubtitle,blogbody,imageid FROM t_blog_detail WHERE blogid= #{blogid}")
	List<GetBlogDetailSubMapperDto> getBlogSubTitle(@Param("blogid") Long blogid);
	
	@Select("SELECT imagepath,imagename,delflg FROM m_image WHERE imageid= #{imageid}")
	GetBlogDetailImageMapperDto getBlogImage(@Param("imageid") Long imageid);
}

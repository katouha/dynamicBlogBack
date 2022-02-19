package com.example.dynamicBlog.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.dynamicBlog.postgresMapperDto.GetBlogListMapperDto;

@Mapper
public interface GetBlogListImpl {
	@Select("SELECT blogid,blogtitle,blogdiscription,registusername,registdate,delflg FROM m_blog_info WHERE blogkbn= #{blogkbn}")
	List<GetBlogListMapperDto> getBlogList(@Param("blogkbn") String blogkbn);
}

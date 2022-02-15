package com.example.dynamicBlog.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dynamicBlog.postgresMapperDto.GetBlogKbnMapperDto;

@Mapper
public interface GetBlogKbnImpl {
	@Select("SELECT * FROM m_blog_kbn")
	List<GetBlogKbnMapperDto> getBlogKbnAll();
}

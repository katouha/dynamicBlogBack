package com.example.dynamicBlog.impl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.dynamicBlog.postgresMapperDto.MLoginMapperDto;


@Mapper
public interface MLoginImpl {
	
	@Select("SELECT * FROM m_management_user WHERE userid= #{userid} AND password=#{password}")
	MLoginMapperDto getLoginInfo(@Param("userid") String userid ,@Param("password") String password);

}

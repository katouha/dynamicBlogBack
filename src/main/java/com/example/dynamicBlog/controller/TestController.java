package com.example.dynamicBlog.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dynamicBlog.requestDto.CreateBlogReqDto;
import com.example.dynamicBlog.responseDto.CreateBlogResDto;

@RestController
@CrossOrigin
public class TestController {
	@RequestMapping(value = "dynamicBlog/test",method = RequestMethod.POST)
    public CreateBlogResDto getTest(@RequestPart("file") MultipartFile file,@RequestPart("test") CreateBlogReqDto reqDto) {
		
		System.out.print("aaaa");
		return new CreateBlogResDto();
	}
}

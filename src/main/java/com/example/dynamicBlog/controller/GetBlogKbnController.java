package com.example.dynamicBlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamicBlog.common.DynamicBlogConstant;
import com.example.dynamicBlog.impl.GetBlogKbnImpl;
import com.example.dynamicBlog.postgresMapperDto.GetBlogKbnMapperDto;
import com.example.dynamicBlog.responseDto.GetBlogKbnResDto;
import com.example.dynamicBlog.responseDto.GetBlogKbnResDto.Result.KbnInfo;


@RestController
@CrossOrigin
public class GetBlogKbnController {
	@Autowired
	GetBlogKbnImpl getBlogKbnImpl;
	
	@RequestMapping(value = "dynamicBlog/getBlogKbnList",method = RequestMethod.GET)
    public GetBlogKbnResDto getBlogKbn() {
		
		GetBlogKbnResDto resDto = new GetBlogKbnResDto();
		List<GetBlogKbnMapperDto> blogList = getBlogKbnImpl.getBlogKbnAll();
		if(blogList.size() < 1) {
			resDto.getResult().setErrorMessage("DB取得エラー");;
			resDto.getResult().setReturnCd(DynamicBlogConstant.BLOG_KBN_GET_ERROR);
		} else {
			List<KbnInfo> kbnList = new ArrayList();
			for(GetBlogKbnMapperDto kbnObj : blogList) {
				if(!kbnObj.isDelflg()) {
					KbnInfo kbnInfo = resDto.getResult(). new KbnInfo();
					kbnInfo.setBlogKbn(kbnObj.getBlogkbn());
					kbnInfo.setKbnName(kbnObj.getKbnname());
					kbnList.add(kbnInfo);
				}
			}
			resDto.getResult().setReturnCd(DynamicBlogConstant.API_SUCCESS);
			resDto.getResult().setErrorMessage("");
			resDto.getResult().setKbnInfo(kbnList);
		}
		
		return resDto;

	}
}

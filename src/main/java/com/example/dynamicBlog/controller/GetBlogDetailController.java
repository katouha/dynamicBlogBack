package com.example.dynamicBlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamicBlog.common.DynamicBlogConstant;
import com.example.dynamicBlog.impl.GetBlogDetailImpl;
import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailImageMapperDto;
import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailMapperDto;
import com.example.dynamicBlog.postgresMapperDto.GetBlogDetailSubMapperDto;
import com.example.dynamicBlog.requestDto.GetBlogDetailReqDto;
import com.example.dynamicBlog.responseDto.GetBlogDetailResDto;
import com.example.dynamicBlog.responseDto.GetBlogDetailResDto.Result.BlogDetail;

@RestController
@CrossOrigin
public class GetBlogDetailController {
	@Autowired
	GetBlogDetailImpl getBlogDetailImpl;
	
	@RequestMapping(value = "dynamicBlog/getBlogDetail",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public GetBlogDetailResDto getBlogList(@RequestBody GetBlogDetailReqDto reqDto) {
		//レスポンスオブジェクト定義
		GetBlogDetailResDto resDto = new GetBlogDetailResDto();
		
		//パラメータチェック
		if(reqDto.getBlogId() == null) {
			return setReqInfo(DynamicBlogConstant.BLOG_ID_PARAM_ERROR);
		}
		
		//リクエスト値をもとにDB検索
		GetBlogDetailMapperDto blogTitleInfo = getBlogDetailImpl.getBlogTitle(reqDto.getBlogId());
		if(blogTitleInfo == null || blogTitleInfo.isDelflg()) {
			return setReqInfo(DynamicBlogConstant.NO_BLOG_UP);
		}
		resDto.getResult().setBlogtitle(blogTitleInfo.getBlogtitle());
		resDto.getResult().setBlogdiscription(blogTitleInfo.getBlogdiscription());
		resDto.getResult().setRegistdate(blogTitleInfo.getRegistdate());
		resDto.getResult().setRegistusername(blogTitleInfo.getRegistusername());
		
		List<GetBlogDetailSubMapperDto> blogSubList = getBlogDetailImpl.getBlogSubTitle(reqDto.getBlogId());
		if(blogSubList == null ) {
			return setReqInfo(DynamicBlogConstant.NO_BLOG_UP);
		}
		List<BlogDetail> resDetailList = new ArrayList();
		for(GetBlogDetailSubMapperDto blogSubObj : blogSubList) {
			BlogDetail resDetailObj = resDto.getResult().new BlogDetail();
			resDetailObj.setBlogsubtitle(blogSubObj.getBlogsubtitle());
			resDetailObj.setBlogbody(blogSubObj.getBlogbody());
			if(blogSubObj.getImageid() != null) {
				GetBlogDetailImageMapperDto imageObj = getBlogDetailImpl.getBlogImage(blogSubObj.getImageid());
				if(imageObj != null) {
					if(!imageObj.isDelflg()) {
						resDetailObj.setImagepath(imageObj.getImagepath());
					}
				}
			}
			resDetailList.add(resDetailObj);
		}
		
		resDto.getResult().setBlogDetail(resDetailList);
		resDto.getResult().setReturnCd(DynamicBlogConstant.API_SUCCESS);
		resDto.getResult().setErrorMessage("");
		
		
		//jsonレスポンス
		return resDto;
	}
	
	private GetBlogDetailResDto setReqInfo(String message) {
		GetBlogDetailResDto resDto = new GetBlogDetailResDto();
		resDto.getResult().setErrorMessage(message);;
		resDto.getResult().setReturnCd(DynamicBlogConstant.PARAM_ERROR_CODE);
		return resDto;
	}
}

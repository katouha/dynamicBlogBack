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
import com.example.dynamicBlog.impl.GetBlogListImpl;
import com.example.dynamicBlog.postgresMapperDto.GetBlogListMapperDto;
import com.example.dynamicBlog.requestDto.GetBlogListReqDto;
import com.example.dynamicBlog.responseDto.GetBlogListResDto;
import com.example.dynamicBlog.responseDto.GetBlogListResDto.Result.BlogInfo;

@RestController
@CrossOrigin
public class GetBlogListController {
	
	@Autowired
	GetBlogListImpl getBlogListImpl;

	@RequestMapping(value = "dynamicBlog/getBlogList",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public GetBlogListResDto getBlogList(@RequestBody GetBlogListReqDto kbn) {
		//レスポンスオブジェクト定義
		GetBlogListResDto resDto = new GetBlogListResDto();
		
		//パラメータチェック
		if(kbn == null) {
			return setReqInfo(DynamicBlogConstant.BLOG_KBN_PARAM_ERROR);
		}
		
		//リクエスト値をもとにDB検索
		List<GetBlogListMapperDto> blogList = new ArrayList();
		blogList = getBlogListImpl.getBlogList(kbn.getKbn());
		
		if(blogList == null) {
			return setReqInfo(DynamicBlogConstant.NO_BLOG_UP);
		}
		
		//ログインユーザ情報をレスポンスオブジェクトに格納
		List<BlogInfo> blogInfoList = new ArrayList();
		for(GetBlogListMapperDto blogInfo : blogList) {
			if(!blogInfo.isDelflg()) {
				BlogInfo blogObj = resDto.getResult().new BlogInfo();
				blogObj.setBlogdiscripton(blogInfo.getBlogdiscription());
				blogObj.setBlogid(blogInfo.getBlogid());
				blogObj.setBlogtitle(blogInfo.getBlogtitle());
				blogObj.setRegistdate(blogInfo.getRegistDate());
				blogObj.setRegistusername(blogInfo.getRegistusername());
				blogInfoList.add(blogObj);
			}
		}
		resDto.getResult().setReturnCd(DynamicBlogConstant.API_SUCCESS);
		resDto.getResult().setErrorMessage("");
		resDto.getResult().setBlogInfo(blogInfoList);
		
		
		//jsonレスポンス
		return resDto;
	}
	
	private GetBlogListResDto setReqInfo(String message) {
		GetBlogListResDto resDto = new GetBlogListResDto();
		resDto.getResult().setErrorMessage(message);;
		resDto.getResult().setReturnCd(DynamicBlogConstant.PARAM_ERROR_CODE);
		return resDto;
	}
}

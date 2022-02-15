package com.example.dynamicBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamicBlog.common.DynamicBlogConstant;
import com.example.dynamicBlog.impl.MLoginImpl;
import com.example.dynamicBlog.postgresMapperDto.MLoginMapperDto;
import com.example.dynamicBlog.requestDto.LoginReqDto;
import com.example.dynamicBlog.responseDto.LoginResDto;
import com.example.dynamicBlog.responseDto.LoginResDto.Result.UserInfo;


/**
 * 
 * @author haya-
 *ブログ管理画面ログインAPI
 */
@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	MLoginImpl mLoginImpl;
	
	@RequestMapping(value = "dynamicBlog/login",method = RequestMethod.POST)
    public LoginResDto getLoginAuth(@RequestBody LoginReqDto reqDto) {
		//レスポンスオブジェクト定義
		LoginResDto resDto = new LoginResDto();
		
		//パラメータチェック
		if(reqDto.getPassword() == null) {
			return setReqInfo(DynamicBlogConstant.PASSWORD_PARAM_ERROR);
		}
		
		if(reqDto.getLoginId() == null) {
			return setReqInfo(DynamicBlogConstant.LOGIN_ID_PARAM_ERROR);
		}
		
		//リクエスト値をもとにDB検索
		MLoginMapperDto loginInfo = new MLoginMapperDto();
		loginInfo = mLoginImpl.getLoginInfo(reqDto.getLoginId(),reqDto.getPassword());
		
		if(loginInfo == null) {
			return setReqInfo(DynamicBlogConstant.NO_REGIST_USER);
		}
		
		//ログインユーザ情報をレスポンスオブジェクトに格納
		UserInfo userInfo = resDto.getResult().new UserInfo();
		userInfo.setUserName(loginInfo.getUserName());
		userInfo.setSuccessFlg(Boolean.TRUE);
		resDto.getResult().setReturnCd(DynamicBlogConstant.API_SUCCESS);
		resDto.getResult().setErrorMessage("");
		resDto.getResult().setUserInfo(userInfo);
		
		
		//jsonレスポンス
		return resDto;
	}
	
	private LoginResDto setReqInfo(String message) {
		LoginResDto resDto = new LoginResDto();
		resDto.getResult().setErrorMessage(message);;
		resDto.getResult().setReturnCd(DynamicBlogConstant.PARAM_ERROR_CODE);
		return resDto;
	}

}

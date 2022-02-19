package com.example.dynamicBlog.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dynamicBlog.common.DynamicBlogConstant;
import com.example.dynamicBlog.impl.CreateBlogImpl;
import com.example.dynamicBlog.requestDto.CreateBlogReqDto;
import com.example.dynamicBlog.responseDto.CreateBlogResDto;

@RestController
@CrossOrigin
public class CreateBlogController {
	@Autowired
	CreateBlogImpl createBlogImpl;
	
	@RequestMapping(value = "dynamicBlog/createBlog",method = RequestMethod.POST)
    public CreateBlogResDto getCreateBlog(@RequestPart(name="file",required = false) MultipartFile file,@RequestPart("jsonData") CreateBlogReqDto reqDto) {
		//レスポンスオブジェクト定義
		CreateBlogResDto resDto = new CreateBlogResDto();
		if(reqDto.getTitle() == null) {
			return setReqInfo(DynamicBlogConstant.BLOG_TITLEPARAM_ERROR);
		}
		if(reqDto.getUserName() == null) {
			return setReqInfo(DynamicBlogConstant.BLOG_REGISTER_PARAM_ERROR);
		}
		if(reqDto.getBlogKbn() == null) {
			return setReqInfo(DynamicBlogConstant.BLOG_KBN_PARAM_ERROR);
		}
		
		if(reqDto.getBlogList() != null) {
			//パラメータチェック
			if(reqDto.getBlogList().getSubTitle() == null) {
				return setReqInfo(DynamicBlogConstant.BLOG_SUBTITLE_PARAM_ERROR);
			}
			if(reqDto.getBlogList().getBody() == null) {
				return setReqInfo(DynamicBlogConstant.BLOG_BODY_PARAM_ERROR);
			}
		}
		
		//リクエスト値をもとにDB検索
		if(reqDto.getApiFlg()) {
			Long blogSeq = createBlogImpl.getBlogSeq();
			createBlogImpl.setBlogInfo(blogSeq, reqDto.getTitle(), reqDto.getBlogKbn(), reqDto.getUserName(),reqDto.getBlogdescription(), false);
			if(file != null) {
				Long imageSeq = createBlogImpl.getBlogSeq();
				String path = "C:\\work\\開発\\image\\" + reqDto.getBlogList().getImageName();
				imageSave(path,file);
				
				createBlogImpl.setImageInfo(imageSeq,path, reqDto.getBlogList().getImageName(), false);
				createBlogImpl.setBlogDetailInfo(blogSeq, reqDto.getBlogList().getSubTitle(), reqDto.getBlogList().getBody(),imageSeq);
			}else {
				createBlogImpl.setBlogDetailInfo2(blogSeq, reqDto.getBlogList().getSubTitle(), reqDto.getBlogList().getBody());
			}
			resDto.getResult().setBlogSeq(blogSeq);
		}else {
			if(file != null) {
				Long seq = reqDto.getBlogSeq();
				Long imageSeq = createBlogImpl.getBlogSeq();
				String path = "C:\\work\\開発\\image\\" + reqDto.getBlogList().getImageName();
				imageSave(path,file);
				createBlogImpl.setImageInfo(imageSeq, path , reqDto.getBlogList().getImageName(), false);
				createBlogImpl.setBlogDetailInfo(seq, reqDto.getBlogList().getSubTitle(), reqDto.getBlogList().getBody(),imageSeq);
			}else {
				Long seq = reqDto.getBlogSeq();
				createBlogImpl.setBlogDetailInfo2(seq, reqDto.getBlogList().getSubTitle(), reqDto.getBlogList().getBody());
			}
		}
		
		//ログインユーザ情報をレスポンスオブジェクトに格納
		resDto.getResult().setReturnCd(DynamicBlogConstant.API_SUCCESS);
		resDto.getResult().setErrorMessage("");
		
		
		//jsonレスポンス
		return resDto;
	}
	
	private void imageSave(String path,MultipartFile file) {
		Path filePath = Paths.get(path);
        try {
            //アップロードファイルをバイト値に変換
            byte[] bytes  = file.getBytes();
            //バイト値を書き込む為のファイルを作成して指定したパスに格納
            OutputStream stream = Files.newOutputStream(filePath);
            stream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private CreateBlogResDto setReqInfo(String message) {
		CreateBlogResDto resDto = new CreateBlogResDto();
		resDto.getResult().setErrorMessage(message);;
		resDto.getResult().setReturnCd(DynamicBlogConstant.PARAM_ERROR_CODE);
		return resDto;
	}
}

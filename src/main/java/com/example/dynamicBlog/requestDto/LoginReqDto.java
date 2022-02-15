package com.example.dynamicBlog.requestDto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReqDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("loginId")
	private String loginId;
	
	@JsonProperty("password")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

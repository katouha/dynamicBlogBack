package com.example.dynamicBlog.requestDto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBlogListReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("kbn")
	private String kbn;

	public String getKbn() {
		return kbn;
	}

	public void setKbn(String kbn) {
		this.kbn = kbn;
	}
	
	
}

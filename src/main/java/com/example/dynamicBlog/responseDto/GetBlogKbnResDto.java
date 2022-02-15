package com.example.dynamicBlog.responseDto;

import java.util.List;

public class GetBlogKbnResDto {
private Result result;
	
	public GetBlogKbnResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private List<KbnInfo> kbnInfo;
		
		public class KbnInfo {
			private String blogKbn;
			private String kbnName;
			public String getBlogKbn() {
				return blogKbn;
			}
			public void setBlogKbn(String blogKbn) {
				this.blogKbn = blogKbn;
			}
			public String getKbnName() {
				return kbnName;
			}
			public void setKbnName(String kbnName) {
				this.kbnName = kbnName;
			}
			
			
		}

		public List<KbnInfo> getKbnInfo() {
			return kbnInfo;
		}

		public void setKbnInfo(List<KbnInfo> kbnInfo) {
			this.kbnInfo = kbnInfo;
		}

	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}

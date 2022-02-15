package com.example.dynamicBlog.responseDto;

public class CreateBlogResDto {
private Result result;
	
	public CreateBlogResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private Long blogSeq;

		public Long getBlogSeq() {
			return blogSeq;
		}

		public void setBlogSeq(Long blogSeq) {
			this.blogSeq = blogSeq;
		}
		
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
}

package com.example.dynamicBlog.responseDto;

import java.util.List;

public class GetBlogDetailResDto {
private Result result;
	
	public GetBlogDetailResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private String blogtitle;
		private String blogdiscription;
		private String registusername;
		private String registdate;
		private List<BlogDetail> blogDetail;
		
		public class BlogDetail {
			private String blogsubtitle;
			private String blogbody;
			private String imagepath;
			public String getBlogsubtitle() {
				return blogsubtitle;
			}
			public void setBlogsubtitle(String blogsubtitle) {
				this.blogsubtitle = blogsubtitle;
			}
			public String getBlogbody() {
				return blogbody;
			}
			public void setBlogbody(String blogbody) {
				this.blogbody = blogbody;
			}
			public String getImagepath() {
				return imagepath;
			}
			public void setImagepath(String imagepath) {
				this.imagepath = imagepath;
			}
			
		}

		public String getBlogtitle() {
			return blogtitle;
		}

		public void setBlogtitle(String blogtitle) {
			this.blogtitle = blogtitle;
		}

		public String getBlogdiscription() {
			return blogdiscription;
		}

		public void setBlogdiscription(String blogdiscription) {
			this.blogdiscription = blogdiscription;
		}

		public String getRegistusername() {
			return registusername;
		}

		public void setRegistusername(String registusername) {
			this.registusername = registusername;
		}

		public String getRegistdate() {
			return registdate;
		}

		public void setRegistdate(String registdate) {
			this.registdate = registdate;
		}

		public List<BlogDetail> getBlogDetail() {
			return blogDetail;
		}

		public void setBlogDetail(List<BlogDetail> blogDetail) {
			this.blogDetail = blogDetail;
		}

		
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}

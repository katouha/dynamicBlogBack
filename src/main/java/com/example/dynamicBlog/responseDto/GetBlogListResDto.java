package com.example.dynamicBlog.responseDto;

import java.sql.Date;
import java.util.List;

public class GetBlogListResDto {
	private Result result;
	
	public GetBlogListResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private List<BlogInfo> blogInfo;
		
		public class BlogInfo {
			private String blogid;
			private String blogtitle;
			private String blogdiscripton;
			private String registusername;
			private Date registdate;
			public String getBlogid() {
				return blogid;
			}
			public void setBlogid(String blogid) {
				this.blogid = blogid;
			}
			public String getBlogtitle() {
				return blogtitle;
			}
			public void setBlogtitle(String blogtitle) {
				this.blogtitle = blogtitle;
			}
			public String getBlogdiscripton() {
				return blogdiscripton;
			}
			public void setBlogdiscripton(String blogdiscripton) {
				this.blogdiscripton = blogdiscripton;
			}
			public String getRegistusername() {
				return registusername;
			}
			public void setRegistusername(String registusername) {
				this.registusername = registusername;
			}
			public Date getRegistdate() {
				return registdate;
			}
			public void setRegistdate(Date registdate) {
				this.registdate = registdate;
			}
		}

		public List<BlogInfo> getBlogInfo() {
			return blogInfo;
		}

		public void setBlogInfo(List<BlogInfo> blogInfo) {
			this.blogInfo = blogInfo;
		}
		
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}

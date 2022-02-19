package com.example.dynamicBlog.responseDto;

import java.sql.Date;
import java.util.List;

public class GetBlogKbnResDto {
private Result result;
	
	public GetBlogKbnResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private List<KbnInfo> kbnInfo;
		
		public class KbnInfo {
			private String blogkbn;
			private String kbnname;
			private String kbndiscription;
			private boolean delflg;
			private Date registdate;
			public String getBlogkbn() {
				return blogkbn;
			}
			public void setBlogkbn(String blogkbn) {
				this.blogkbn = blogkbn;
			}
			public String getKbnname() {
				return kbnname;
			}
			public void setKbnname(String kbnname) {
				this.kbnname = kbnname;
			}
			public String getKbndiscription() {
				return kbndiscription;
			}
			public void setKbndiscription(String kbndiscription) {
				this.kbndiscription = kbndiscription;
			}
			public boolean isDelflg() {
				return delflg;
			}
			public void setDelflg(boolean delflg) {
				this.delflg = delflg;
			}
			public Date getRegistdate() {
				return registdate;
			}
			public void setRegistdate(Date registdate) {
				this.registdate = registdate;
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

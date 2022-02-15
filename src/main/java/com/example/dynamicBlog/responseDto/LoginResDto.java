package com.example.dynamicBlog.responseDto;

public class LoginResDto {

	private Result result;
	
	public LoginResDto() {
		this.result = new Result();
	}
	
	public class Result extends ResponseBase{
		private UserInfo userInfo;
		
		public class UserInfo {
			private String userName;
			private Boolean successFlg;
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public Boolean getSuccessFlg() {
				return successFlg;
			}
			public void setSuccessFlg(Boolean successFlg) {
				this.successFlg = successFlg;
			}
		}

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
		
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
}

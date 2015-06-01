package com.dragon.codingol.common;

public class ResultJson  {
	
	private boolean success;
	private String msg;
	
	public ResultJson(){
		success = true;
		msg = "保存成功";
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setFailure(String msg){
		this.msg = msg;
		this.success = false;
	}
}

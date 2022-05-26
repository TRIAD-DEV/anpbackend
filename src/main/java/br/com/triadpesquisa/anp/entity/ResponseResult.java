package br.com.triadpesquisa.anp.entity;

public class ResponseResult {
	private boolean onSuccess;
	private Object data;
	
	public void Error(String json) {
		this.onSuccess = false;
		this.data = json;
	}
	
	public void Success(Object object) {
		this.onSuccess = true;
		this.data = object;
	}

	public boolean isOnSuccess() {
		return onSuccess;
	}

	public Object getData() {
		return data;
	}
}
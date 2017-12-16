package com.ts.game.model;

public class ResponseModel<T> {
	private String code;
	private T content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}

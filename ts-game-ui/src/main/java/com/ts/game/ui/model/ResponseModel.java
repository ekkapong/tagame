package com.ts.game.ui.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String status;
    private String code;
    private Object content;

    public ResponseModel() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public Object getContent() {
	return content;
    }

    public void setContent(Object content) {
	this.content = content;
    }

}

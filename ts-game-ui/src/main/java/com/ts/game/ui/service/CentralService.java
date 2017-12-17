package com.ts.game.ui.service;

import java.util.Date;

import com.ts.game.ui.model.ResponseModel;

public class CentralService {

    private RestfulService restfulService;
    private String baseUrl;

    public CentralService() {
	super();
	restfulService = new RestfulService();
    }

    public void activate(String ip, String port) {
	String time = new Date().getTime() + "";
	String url = baseUrl + "/activate?ip={ip}&port{port}&t={time}";
	restfulService.get(url);
    }

    public ResponseModel active(String ip) {
	return null;
    }

    public ResponseModel inquire(String geokey) {
	return null;
    }

    public String getBaseUrl() {
	return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
	this.baseUrl = baseUrl;
    }

    public RestfulService getRestfulService() {
	return restfulService;
    }

}

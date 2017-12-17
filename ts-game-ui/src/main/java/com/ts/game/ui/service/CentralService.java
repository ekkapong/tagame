package com.ts.game.ui.service;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sun.jersey.api.client.ClientResponse;
import com.ts.game.ui.model.ResponseModel;

public class CentralService {

    private RestfulService restfulService;
    private String baseUrl;

    public CentralService() {
	super();
	restfulService = new RestfulService();
    }

    private void alert(ClientResponse response) {
	if (response != null) {
	    String message = "Success";

	    if (response.getStatus() != 200)
		message = "Fail";
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, response.getStatus() + "", message));
	}
    }

    public void activate(String ip, String port) {
	String time = new Date().getTime() + "";
	String url = baseUrl + "/activate?ip={ip}&port{port}&t={time}";

	url = url.replace("{ip}", ip);
	url = url.replace("{port}", ip);
	url = url.replace("{time}", time);

	ClientResponse response = restfulService.get(url);

	alert(response);

    }

    public ClientResponse active(String ip) {
	String time = new Date().getTime() + "";
	String url = baseUrl + "/active?ip={ip}&t={time}";

	url = url.replace("{ip}", ip);
	url = url.replace("{time}", time);

	ClientResponse response = restfulService.get(url);
	alert(response);
	return response;
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

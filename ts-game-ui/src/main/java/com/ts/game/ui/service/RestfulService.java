package com.ts.game.ui.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestfulService {

    public ClientResponse post(String url, String requestJson) {

	try {
	    Client client = Client.create();

	    WebResource webResource = client.resource(url);

	    ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, requestJson);

	    return response;

	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
	    e.printStackTrace();
	}
	return null;
    }

    public ClientResponse get(String url) {

	try {
	    Client client = Client.create();

	    WebResource webResource = client.resource(url);

	    ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

	    return response;

	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
	    e.printStackTrace();
	}
	return null;
    }
}

package com.ts.game.ui.model;

import java.io.Serializable;

public class Merchant implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String merchant_id;
    private String terminal_id;
    private String device_unique_id;

    public Merchant() {
	super();
    }

    public String getMerchant_id() {
	return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
	this.merchant_id = merchant_id;
    }

    public String getTerminal_id() {
	return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
	this.terminal_id = terminal_id;
    }

    public String getDevice_unique_id() {
	return device_unique_id;
    }

    public void setDevice_unique_id(String device_unique_id) {
	this.device_unique_id = device_unique_id;
    }

}
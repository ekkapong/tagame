package com.ts.game.ui.model;

import java.io.Serializable;

public class NodeModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String desciption;
    private String image1;
    private String image2;
    private String image3;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDesciption() {
	return desciption;
    }

    public void setDesciption(String desciption) {
	this.desciption = desciption;
    }

    public String getImage1() {
	return image1;
    }

    public void setImage1(String image1) {
	this.image1 = image1;
    }

    public String getImage2() {
	return image2;
    }

    public void setImage2(String image2) {
	this.image2 = image2;
    }

    public String getImage3() {
	return image3;
    }

    public void setImage3(String image3) {
	this.image3 = image3;
    }

}

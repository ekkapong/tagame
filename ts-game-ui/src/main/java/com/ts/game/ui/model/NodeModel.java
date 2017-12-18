package com.ts.game.ui.model;

import java.io.Serializable;

public class NodeModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String title;
    private String desciption;
    private NodeImageModel images;

    public NodeImageModel getImages() {
	return images;
    }

    public void setImages(NodeImageModel images) {
	this.images = images;
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

}

package com.ts.game.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ts.game.calculation.DistanceCalculation;
import com.ts.game.dto.Node;
import com.ts.game.model.ErrorModel;
import com.ts.game.model.ImageModel;
import com.ts.game.model.NodeModel;
import com.ts.game.model.ResponseModel;
import com.ts.game.utils.NodeUtils;

@WebServlet("/inquire")
public class InquireServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		try {
		    ResponseModel<NodeModel> responseModel = new ResponseModel<NodeModel>();
		    NodeModel nodeModel = null;
		    String geokey = request.getParameter("geokey");
		    if(geokey != null) {
		    	String latitude = geokey.indexOf(":")!=-1 ? geokey.split(":")[0] : null; 
		    	String longtitude = geokey.indexOf(":")!=-1 ? geokey.split(":")[1] : null;
		    	
		    	List<Node> nodes = NodeUtils.getNodeList();
		    	if(nodes != null) {
		    		for (Node node : nodes) {
			    		String latNode = node.getGeokey().indexOf(":")!=-1 ? node.getGeokey().split(":")[0] : null; 
				    	String longNode = node.getGeokey().indexOf(":")!=-1 ? node.getGeokey().split(":")[1] : null;
				    	
			    		double distance = DistanceCalculation.distance(Double.valueOf(latitude), Double.valueOf(longtitude), Double.valueOf(latNode), Double.valueOf(longNode));
			    		if(distance < 10 ) {
						    //find node within 10 km.
			    			nodeModel = new NodeModel();
						    nodeModel.setTitle(node.getTitle());
						    nodeModel.setDesc(node.getDesc());
						    
						    ImageModel images = new ImageModel();
						    images.setImage1(node.getImage1());
						    images.setImage2(node.getImage2());
						    images.setImage3(node.getImage3());
						   
						    nodeModel.setImages(images);

			    			break;
			    		}
					}
			    	if(nodeModel != null) {
					    responseModel.setCode("200");
					    responseModel.setContent(nodeModel);	
					    response.getOutputStream().print(gson.toJson(responseModel));
			    	} else {
			    		response.getOutputStream().print(gson.toJson(getError()));
			    	}
		    	} else {
		    		response.getOutputStream().print(gson.toJson(getError()));
		    	}

			    response.setContentType("application/json");
			    response.getOutputStream().flush();
			    

		    } else {
			    response.getOutputStream().print(gson.toJson(getError()));
			    response.getOutputStream().flush();
		    }

		} catch (Exception ex) {
		    ex.printStackTrace();
		    response.setContentType("application/json");
		    response.getOutputStream().print(gson.toJson(getError()));
		    response.getOutputStream().flush();
		}
	}
	
	private ResponseModel<ErrorModel> getError(){
	    ResponseModel<ErrorModel> errorResponnse = new ResponseModel<ErrorModel>();
	    errorResponnse.setCode("422 NODE_NOT_FOUND");
	    ErrorModel errorModel = new ErrorModel();
	    errorModel.setError("Node not found");
	    errorResponnse.setContent(errorModel);
	    return errorResponnse;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

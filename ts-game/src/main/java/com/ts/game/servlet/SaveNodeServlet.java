package com.ts.game.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ts.game.dto.Node;
import com.ts.game.model.NodeWithGeoKeyModel;
import com.ts.game.utils.NodeUtils;
import com.ts.game.utils.StringUtils;


@WebServlet("/save")
public class SaveNodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Gson gson = new Gson();
			String reqJson = StringUtils.BufferedReaderToString(request.getReader());
			NodeWithGeoKeyModel nodeWithGeokey = gson.fromJson(reqJson, NodeWithGeoKeyModel.class);
			
			Node node = new Node();
			node.setGeokey(nodeWithGeokey.getGeokey());
			
			if(nodeWithGeokey.getNode() != null) {
				node.setTitle(nodeWithGeokey.getNode().getTitle());
				node.setDesc(nodeWithGeokey.getNode().getDesc());
				if(nodeWithGeokey.getNode().getImages() != null) {
					node.setImage1(nodeWithGeokey.getNode().getImages().getImage1());
					node.setImage2(nodeWithGeokey.getNode().getImages().getImage2());
					node.setImage3(nodeWithGeokey.getNode().getImages().getImage3());
				}
			}
			
			//save node
			List<Node> nodeList;
			if(NodeUtils.getNodeList() != null && !NodeUtils.getNodeList().isEmpty()) {
				nodeList = NodeUtils.getNodeList();
			} else {
				nodeList = new ArrayList<>();
			}
			nodeList.add(node);
			NodeUtils.setNodeList(nodeList);
		    			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

}

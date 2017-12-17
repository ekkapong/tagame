package com.ts.game.utils;

import java.util.List;

import com.ts.game.dto.Node;

public class NodeUtils {
	public static List<Node> nodeList;

	public static List<Node> getNodeList() {
		return nodeList;
	}

	public static void setNodeList(List<Node> nodeList) {
		NodeUtils.nodeList = nodeList;
	}
	
}

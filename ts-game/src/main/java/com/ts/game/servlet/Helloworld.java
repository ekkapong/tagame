package com.ts.game.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Helloworld
 */
@WebServlet("/Helloworld")
public class Helloworld extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Helloworld() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Gson gson = new Gson();
	String objectToReturn = "{ key1: 'value1', key2: 'value2' }";

	response.setContentType("application/json;charset=UTF-8");
	PrintWriter out = response.getWriter();
	// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
	out.print(objectToReturn);
	out.flush();
//	try (PrintWriter out = response.getWriter()) {
//	    ExampleModel exampleModel = new ExampleModel();
//
//	    exampleModel.setName("Test");
//	    exampleModel.setPassword("Password");
//
//	    out.print(gson.toJson(exampleModel));
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}

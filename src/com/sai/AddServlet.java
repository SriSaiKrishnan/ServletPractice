/**
 * 
 */
package com.sai;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sv
 *
 */
public class AddServlet extends HttpServlet {
	
	//In index.html file if the method is get the doGet Method is called. If it is post doPost will called.
	//If the respective method is not there Tomcat will throw 404 Error.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i+j;

		/*
		 * In order to forward the request to other servlet there are options available
		 * 1. Request Dispacther - It will create only one request and response object
		 * 2. sendRedirect - It will create two request and response object
		 * 	2.1. URL Rewritting
		 * 	2.2. Session Management
		 * 	2.3. Cookies
		 */
		
		/* request.setAttribute("k", k); // Setting the attribute value so that it can be used in other servlet
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("square");
		dispatcher.forward(request, response);  // Forwarding the request to other Servlet to find the Square root */
		
		//URL Rewritting
		//response.sendRedirect("square?k="+k); // Getting the Value from URL Parameter since we are passing the response which doesn't have data
	
		//Session Management
		
		/* HttpSession session = request.getSession();
		session.setAttribute("k", k);
		
		response.sendRedirect("square"); // Forwarding the request to square servlet with same session */
		
		Cookie cookie = new Cookie("k", k + "");
		response.addCookie(cookie);		
		
		response.sendRedirect("square");
	}

}

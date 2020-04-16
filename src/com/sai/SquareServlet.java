package com.sai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SquareServlet
 */
@WebServlet("/SquareServlet")
public class SquareServlet extends HttpServlet {
	
	
	/* 	This doGet is for dispatcher.forward
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int square = (int)request.getAttribute("k");
		
		square = square*square;
		
		PrintWriter out = response.getWriter();
		
		out.println("Square Root is " + square);
		
	} */
	

	/* This doGet is for sendRedirect - URL Rewritting
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int square = Integer.parseInt(request.getParameter("k"));
		
		square = square*square;
		
		PrintWriter out = response.getWriter();
		
		out.println("Square Root is " + square);
		
	}*/
	
	/* This doGet is For sendRedirect - Session Management
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession();
		
		int square = (int) session.getAttribute("k");
		
		square =  square*square;
		
		PrintWriter out = response.getWriter();
		
		out.println("Square Root is " + square);
	}*/
	
	//This doGet is For sendRedirect - Cookie Management
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookies[] = request.getCookies();
		int square = 0;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("k")) {
				square =Integer.parseInt(cookie.getValue());
			}
		}
		
		square = square*square;
		
		PrintWriter out = response.getWriter();
		
		out.println("Square Root is " + square);
		
	}
	
}

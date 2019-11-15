package com.animal.error;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ErrorCatcherCode500 extends HttpServlet {
	private String characterEncoding;
	private String contentType;
	
	
	@Override
	public void init(ServletConfig config) {
		characterEncoding = config.getInitParameter("characterEncoding");
		contentType = config.getInitParameter("contentType");
	}
	
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		req.setCharacterEncoding(characterEncoding);
		resp.setContentType(contentType);
		
		Integer code = (Integer)req.getAttribute("javax.servlet.error.status_code");
		String message = (String)req.getAttribute("javax.servlet.error.message");
		String requestURI = (String)req.getAttribute("javax.servlet.error.request_uri");
		Throwable errorObject = (Throwable)req.getAttribute("javax.servlet.error.exception");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>❗ Occurred Error</h1>");
		out.print("<hr/>");
		out.print("<p>📑 Error Code : " + code + "</p>");
		out.print("<p>📑 Error Message : " + message + "</p>");
		out.print("<p>📑 Request URI : " + requestURI + "</p>");
		out.print("<p>📑 Error Type : " + errorObject + "</p>");
		
		out.close();
	}
}

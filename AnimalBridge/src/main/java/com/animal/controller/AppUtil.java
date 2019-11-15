package com.animal.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) { 
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}  catch (Exception e) {
			System.out.println("AppUtil - forward() 에러 : " + e.getMessage());
		}
	}
}

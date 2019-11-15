package com.animal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SubController {
	abstract public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException;
}

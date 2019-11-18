package com.animal.controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.MapService;


public class MapShowController implements SubController{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/view/mapView/Map.jsp";
		
		MapService mapService = MapService.getInstance();
		String json = mapService.getJsonAll(); 
		
		System.out.println(json);
        req.setAttribute("json", json);

        AppUtil.forward(req, resp, path);
	}
}

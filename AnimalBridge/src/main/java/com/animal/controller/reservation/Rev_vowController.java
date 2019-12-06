package com.animal.controller.reservation;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;

public class Rev_vowController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/reservationView/rev_vow.jsp";

		String centerIdx = req.getParameter("centerIdx");
		String animalIdx = req.getParameter("animalIdx");
		req.setAttribute("centerIdx", centerIdx);
		req.setAttribute("animalIdx", animalIdx);
		
		
		AppUtil.forward(req, resp, path);
	}

}

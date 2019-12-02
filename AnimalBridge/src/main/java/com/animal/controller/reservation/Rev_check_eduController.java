package com.animal.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;

public class Rev_check_eduController implements SubController{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "";
		HttpSession session = req.getSession();
		String nick_name = (String)session.getAttribute("memberLogInNickName");
		
		if(nick_name==null) {
			path = "/view/memberView/memberLogIn.jsp";
		}else{
			Service service = Service.getInstance(); 
			int checkEdu = service.checkEdu(nick_name);
			
			if(checkEdu == 1) {
				path = "rev_calendar.do";
			}else {
				path = "/AnimalBridge/view/index.jsp";
			}
			String centerIdx = req.getParameter("centerIdx");
			String animalIdx = req.getParameter("animalIdx");
			req.setAttribute("centerIdx", centerIdx);
			req.setAttribute("animalIdx", animalIdx);
		}
		AppUtil.forward(req, resp, path);
	}

}

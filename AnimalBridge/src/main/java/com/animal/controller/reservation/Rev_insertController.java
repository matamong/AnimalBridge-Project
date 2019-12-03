package com.animal.controller.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;

public class Rev_insertController implements SubController{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/index.jsp"; //마이페이지로 변경할것.
		HttpSession session = req.getSession();
		Service service = Service.getInstance();
		
		
		String revDate = req.getParameter("year")+"-"+req.getParameter("month")+"-"+req.getParameter("day");
		String revTime = req.getParameter("revTime");
		int animalIdx = Integer.parseInt(req.getParameter("animalIdx"));
		int centerIdx = Integer.parseInt(req.getParameter("centerIdx"));
		String nick_name = (String)session.getAttribute("memberLogInNickName");
		String phone = service.getPhone(nick_name);
		
		int result = service.reservationInsert(revDate, revTime, animalIdx, centerIdx, nick_name, phone);
			
		if(result==1) {
			System.out.println("예약성공");
		}else {
			System.out.println("예약실패");
		}
		
		AppUtil.forward(req, resp, path);
	}

}

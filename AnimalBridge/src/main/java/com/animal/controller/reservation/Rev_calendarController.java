package com.animal.controller.reservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;

import com.animal.vo.ReservationVO;

public class Rev_calendarController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/reservationView/rev_calendar.jsp";
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		

			if(req.getParameter("year") != null) { 
				 year = Integer.parseInt(req.getParameter("year"));
			}
			if(req.getParameter("month") != null) { 
			
				int monthNext = Integer.parseInt(req.getParameter("month"));
				
				 if(monthNext<0) {
					 month = monthNext+12;
					 year -= 1;
				 }else if(0<= monthNext && monthNext < 12) {
					 month = monthNext;
				 }else if( monthNext >= 12){
					 month = monthNext-12;
					 year += 1;
				 }
			}		 
		
		cal.set(year, month, 1);
		week = cal.get(Calendar.DAY_OF_WEEK);
	    lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	   
		req.setAttribute("year", year);
		req.setAttribute("month", month);
		req.setAttribute("week", week);
		req.setAttribute("lastday", lastday);
		 
		
		Service service = Service.getInstance(); 
		ArrayList<ReservationVO> listAll = service.reservationCheckAll(year, month, lastday);
		req.setAttribute("listAll", listAll);
		
		
		String centerIdx = req.getParameter("centerIdx");
		String animalIdx = req.getParameter("animalIdx");
		req.setAttribute("centerIdx", centerIdx);
		req.setAttribute("animalIdx", animalIdx);
		
		AppUtil.forward(req, resp, path);
	}

}

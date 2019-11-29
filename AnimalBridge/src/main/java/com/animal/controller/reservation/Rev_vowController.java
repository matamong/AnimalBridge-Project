package com.animal.controller.reservation;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;

public class Rev_vowController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/reservationView/rev_calendar.jsp";
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		
		/* 다른달 달력으로 바꾸고 싶을때
		cal.set(2019, 11, 1);
	    week = cal.get(Calendar.DAY_OF_WEEK);
	    month = cal.get(Calendar.MONTH)+1;
	    lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		*/
		
		
		req.setAttribute("year", year);
		req.setAttribute("month", month);
		req.setAttribute("week", week);
		req.setAttribute("lastday", lastday);
		 
		AppUtil.forward(req, resp, path);
	}

}

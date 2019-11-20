package com.animal.controller.happyBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.HappyBoardVO;

public class HappyBoardViewController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/happyBoardView/happyBoardView.jsp";
		String requestIdx = req.getParameter("happyBoardViewIdx");
		
		Service service = Service.getInstance();
		HappyBoardVO resultHappyBoardViewVO = service.getHappyBoardViewByIdx(Integer.parseInt(requestIdx));
		
		if(resultHappyBoardViewVO != null) {
			req.setAttribute("resultHappyBoardViewVO", resultHappyBoardViewVO);
			AppUtil.forward(req, resp, path);
		}
	}
}

package com.animal.controller.animals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.AnimalsVO;

public class AnimalsViewController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/animalsView/animalsView.jsp";
		String requestIdx = req.getParameter("animalsViewIdx");
		
		Service service = Service.getInstance();
		AnimalsVO animalsVO = service.getAnimalsViewByIdx(Integer.parseInt(requestIdx));
		
		if(animalsVO != null) {
			req.setAttribute("resultAnimalsViewVO", animalsVO);
			AppUtil.forward(req, resp, path);
		}
	}
}

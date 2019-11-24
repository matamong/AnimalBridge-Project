package com.animal.controller.animals;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.AnimalsVO;

public class AnimalsListController implements SubController {
	private static final int PAGE_DIV_DEGREE;
	
	static {
		PAGE_DIV_DEGREE = 5;
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/animalsView/animalsList.jsp";
		
		String requestPage = req.getParameter("requestPage");
		if(requestPage == null || requestPage.isEmpty()) {
			requestPage = "0";
		}
		
		String requestAnimalType = req.getParameter("requestAnimalType");
		if(requestAnimalType == null || requestAnimalType.isEmpty()) {
			requestAnimalType = "all";
		}
		
		Service service = Service.getInstance();
		int totalAnimalsListCnt = service.getTotalAnimalsListCnt(requestAnimalType);
		int totalAnimalsPageCnt = totalAnimalsListCnt / PAGE_DIV_DEGREE;
		
		if(totalAnimalsListCnt % PAGE_DIV_DEGREE > 0) {
			totalAnimalsPageCnt++;
		}
		
		req.setAttribute("totalAnimalsPageCnt", totalAnimalsPageCnt);
		
		
		int parsedRequestPage = Integer.parseInt(requestPage);
		if(parsedRequestPage < 0) {
			parsedRequestPage = 0;
		}
		
		if(parsedRequestPage >= totalAnimalsPageCnt) {
			parsedRequestPage = totalAnimalsPageCnt - 1;
		}
		
		req.setAttribute("animalsListCurrentPage", parsedRequestPage);
		
		
		int beginPage = (parsedRequestPage - 2) > 0 ? (parsedRequestPage - 2) : 0;
		
		int endPage = beginPage + 4;
		if(endPage + 1 > totalAnimalsPageCnt) {
			endPage = totalAnimalsPageCnt - 1;
		}
		
		req.setAttribute("animalsListBeginPage", beginPage);
		req.setAttribute("animalsListEndPage", endPage);
		
		
		List<AnimalsVO> animalsList = service.getAnimalsList(parsedRequestPage, PAGE_DIV_DEGREE, requestAnimalType);
		req.setAttribute("animalsList", animalsList);
		
		AppUtil.forward(req, resp, path);
	}
}

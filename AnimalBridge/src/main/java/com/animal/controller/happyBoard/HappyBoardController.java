package com.animal.controller.happyBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.HappyBoardVO;

public class HappyBoardController implements SubController {
	private static final int PAGE_DIV_DEGREE;
	
	static {
		PAGE_DIV_DEGREE = 5;
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/happyBoardView/happyBoard.jsp";
		
		String requestPage = req.getParameter("requestPage");
		if(requestPage == null || requestPage.isEmpty()) {
			requestPage = "0";
		}
		
		Service service = Service.getInstance();
		
		int totalHappyBoardViewCnt = service.getHappyBoardViewTotalCnt();
		int totalHappyBoardPageCnt = totalHappyBoardViewCnt / PAGE_DIV_DEGREE;
		
		if(totalHappyBoardViewCnt % PAGE_DIV_DEGREE > 0) {
			totalHappyBoardPageCnt++;
		}
		req.setAttribute("totalHappyBoardPageCnt", totalHappyBoardPageCnt);
		
		
		int parsedRequestPage = Integer.parseInt(requestPage);
		int beginPage = (parsedRequestPage - 2) > 0 ? (parsedRequestPage - 2) : 0;
		
		int endPage = beginPage + 4;
		if(endPage + 1 > totalHappyBoardPageCnt) {
			endPage = totalHappyBoardPageCnt - 1;
		}
		req.setAttribute("happyBoardBeginPage", beginPage);
		req.setAttribute("happyBoardEndPage", endPage);
		
		
		List<HappyBoardVO> happyBoardViewList = service.getHappyBoardViewList(parsedRequestPage, PAGE_DIV_DEGREE);
		req.setAttribute("happyBoardViewList", happyBoardViewList);
		
		AppUtil.forward(req, resp, path);
	}
}

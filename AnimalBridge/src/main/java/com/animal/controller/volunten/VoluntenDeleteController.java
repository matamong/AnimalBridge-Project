package com.animal.controller.volunten;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.MemberVO;

public class VoluntenDeleteController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/view/voluntenView/voluntenDeleteResult.jsp";
		HttpSession session = req.getSession();
		MemberVO mVo = (MemberVO)session.getAttribute("memberLogIn");
		int v_no = Integer.parseInt(req.getParameter("v_no"));
		String email = mVo.getNickName();
		
		
		
		Service service = Service.getInstance();
		
		int result = service.voluntenDelete(v_no);
		
		if(result > 0) {
			
			req.setAttribute("result", "모집글 삭제가 정상적으로 처리되었습니다");
			session.removeAttribute("memberLogIn");
			
		} else {
			
			req.setAttribute("error", "모집글 삭제가 처리되지 못했습니다");
		
		}
		
		AppUtil.forward(req, resp, path);
	}	

}

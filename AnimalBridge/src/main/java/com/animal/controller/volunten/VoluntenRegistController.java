package com.animal.controller.volunten;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.VoluntenVO;

public class VoluntenRegistController implements SubController {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/view/voluntenView/VoluntenMain.jsp";
		
		int v_no = Integer.parseInt(req.getParameter("v_no"));
		String v_title = req.getParameter("v_title");
		int v_recruit = Integer.parseInt(req.getParameter("v_recruit"));
		String v_require = req.getParameter("v_require");
		int v_noshow = Integer.parseInt(req.getParameter("v_noshow"));
		int v_cidx = Integer.parseInt(req.getParameter("v_cidx"));
		String v_context = req.getParameter("v_context");
		Timestamp v_regdate = Timestamp.valueOf(req.getParameter("v_regdate"));
		Timestamp v_enddate = Timestamp.valueOf(req.getParameter("v_enddate"));
		Timestamp v_expdate = Timestamp.valueOf(req.getParameter("v_expdate"));
		
		VoluntenVO vo = new VoluntenVO(
				v_no,
				v_title,
				v_recruit,
				v_require,
				v_noshow,
				v_cidx,
				v_context,
				v_regdate,
				v_enddate,
				v_expdate
				);

		Service service = Service.getInstance();
		
		int result = service.voluntenInsert(vo);
		
		if(result > 0) {
			
			req.setAttribute("result", vo);
		
		} else {
			
			req.setAttribute("error", "모집글 등록에 실패했습니다.");
		
		}
		
		AppUtil.forward(req, resp, path);
				
	}

}

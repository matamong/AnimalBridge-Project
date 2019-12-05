package com.animal.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;

public class MemberMyPageFormController implements SubController{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/view/memberView/memberMyPage.jsp";
		
		AppUtil.forward(req, resp, path);
	}
}

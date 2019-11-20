package com.animal.controller.happyBoard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.HappyBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HappyBoardWriterController implements SubController {
	private static final String IMG_PATH;
	
	static {
		IMG_PATH = "/AnimalBridge/view/happyBoardView/images/";
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/happyBoardView/happyBoardView.jsp";
		
		String folderName = "view/happyBoardView/images";
		String realPath = req.getServletContext().getRealPath(folderName);
		
		System.out.println(realPath);
		
		String encType = "UTF-8";
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest multi = new MultipartRequest(req,
													  realPath,
													  maxSize,
													  encType,
													  new DefaultFileRenamePolicy());
		
		String nickName = (String)req.getSession().getAttribute("memberLogInNickName");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		@SuppressWarnings("unchecked")
		Enumeration<String> formTagNames = multi.getFileNames();
		
		String savePath_1 = "";
		String savePath_2 = "";
		String savePath_3 = "";
		
		String formTagName_3 = formTagNames.nextElement();
		String fileName_3 = multi.getFilesystemName(formTagName_3);
		if(fileName_3 != null) {
			savePath_3 = folderName + "/" + fileName_3;
		}
		
		String formTagName_2 = formTagNames.nextElement();
		String fileName_2 = multi.getFilesystemName(formTagName_2);
		if(fileName_2 != null) {
			savePath_2 = folderName + "/" + fileName_2;
		}
		
		String formTagName_1 = formTagNames.nextElement();
		String fileName_1 = multi.getFilesystemName(formTagName_1);
		if(fileName_1 != null) {
			savePath_1 = folderName + "/" + fileName_1;
		}	
		
		HappyBoardVO happyBoardVO = new HappyBoardVO();
		happyBoardVO.setNickName(nickName);
		happyBoardVO.setTitle(title);
		happyBoardVO.setContent(content);
		happyBoardVO.setImg_1(savePath_1);
		happyBoardVO.setImg_2(savePath_2);
		happyBoardVO.setImg_3(savePath_3);
		
		// 입력한 후, 해당 게시글의 idx번호로 검색한 HappyBoardVO객체를 반환 받자
		Service service = Service.getInstance();
		int result = service.happyBoardWrite(happyBoardVO);
		
		if(result > 0) {
			int contentIdx = service.getHappyBoardWriterResultIdx(happyBoardVO);
			HappyBoardVO resultVO = service.getHappyBoardViewByIdx(contentIdx);
			
			System.out.println("IDX : " + resultVO.getIdx());
			System.out.println("NICK_NAME : " + resultVO.getNickName());
			System.out.println("IMG_1 : " + resultVO.getImg_1());
			System.out.println("IMG_2 : " + resultVO.getImg_2());
			System.out.println("IMG_3 : " + resultVO.getImg_3());
			System.out.println("CONTENT : " + resultVO.getContent());
			System.out.println("TITLE : " + resultVO.getTitle());
			
			
//			path += "?happyBoardContentIdx=" + contentIdx;
//			System.out.println(path);
//			
//			AppUtil.forward(req, resp, path);
		}
	}
}



















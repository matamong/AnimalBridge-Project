package com.animal.controller.animals;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.AnimalsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AnimalsWriterController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/animalsView/animalsView.do";
		
		String folderName = "images";
		String folderDir = "view/animalsView/";
		String realPath = req.getServletContext().getRealPath(folderDir + folderName);
		
		System.out.println(realPath);
		
		String encType = "UTF-8";
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest multi = new MultipartRequest(req,
													  realPath,
													  maxSize,
													  encType,
													  new DefaultFileRenamePolicy());
		
		int centerIdx = Integer.parseInt(multi.getParameter("centerIdx"));
		String animalType = multi.getParameter("animalType");
		String animalSort = multi.getParameter("animalSort");
		String animalGender = multi.getParameter("animalGender");
		String animalNeuter = multi.getParameter("animalNeuter");
		String animalInoculation = multi.getParameter("animalInoculation");
		String animalFeature = multi.getParameter("animalFeature");
		
		
		@SuppressWarnings("unchecked")
		Enumeration<String> formTagNames = (Enumeration<String>)multi.getFileNames();
		String img_1 = "";
		String img_2 = "";
		String img_3 = "";
		String img_4 = "";
		String img_5 = "";
		String img_6 = "";
		
		String formTagName_6 = formTagNames.nextElement();
		String fileName_6 = multi.getFilesystemName(formTagName_6);
		if(fileName_6 != null) {
			img_6 = folderName + "/" + fileName_6;
		}
		
		String formTagName_5 = formTagNames.nextElement();
		String fileName_5 = multi.getFilesystemName(formTagName_5);
		if(fileName_5 != null) {
			img_5 = folderName + "/" + fileName_5;
		}
		
		String formTagName_4 = formTagNames.nextElement();
		String fileName_4 = multi.getFilesystemName(formTagName_4);
		if(fileName_4 != null) {
			img_4 = folderName + "/" + fileName_4;
		}
		
		String formTagName_3 = formTagNames.nextElement();
		String fileName_3 = multi.getFilesystemName(formTagName_3);
		if(fileName_3 != null) {
			img_3 = folderName + "/" + fileName_3;
		}
		
		String formTagName_2 = formTagNames.nextElement();
		String fileName_2 = multi.getFilesystemName(formTagName_2);
		if(fileName_2 != null) {
			img_2 = folderName + "/" + fileName_2;
		}
		
		String formTagName_1 = formTagNames.nextElement();
		String fileName_1 = multi.getFilesystemName(formTagName_1);
		if(fileName_1 != null) {
			img_1 = folderName + "/" + fileName_1;
		}
		
		
		AnimalsVO animalsVO = new AnimalsVO();
		animalsVO.setCenterIdx(centerIdx);
		animalsVO.setAnimalType(animalType);
		animalsVO.setAnimalSort(animalSort);
		animalsVO.setAnimalGender(animalGender);
		animalsVO.setAnimalNeuter(animalNeuter);
		animalsVO.setAnimalInoculation(animalInoculation);
		animalsVO.setAnimalFeature(animalFeature);
		animalsVO.setImg_1(img_1);
		animalsVO.setImg_2(img_2);
		animalsVO.setImg_3(img_3);
		animalsVO.setImg_4(img_4);
		animalsVO.setImg_5(img_5);
		animalsVO.setImg_6(img_6);
		
		Service service = Service.getInstance();
		int result = service.animalsWriter(animalsVO);
		
		if(result > 0) {
			int contentIdx = service.getAnimalsWriterResultIdx(animalsVO);
			path += "?animalsViewIdx=" + contentIdx;
			
			AppUtil.forward(req, resp, path);
		}
	}
}

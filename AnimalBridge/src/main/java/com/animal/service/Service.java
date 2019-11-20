package com.animal.service;

import com.animal.dao.HappyWriteDAO;
import com.animal.dao.MemberDAO;
import com.animal.vo.HappyBoardVO;
import com.animal.vo.MemberVO;

public class Service {
	private final MemberDAO memberDAO;
	private final HappyWriteDAO happyWriteDAO;
	private static final Service service;
	
	static {
		service = new Service();
	}
	
	private Service() { 
		memberDAO = MemberDAO.getInstance();
		happyWriteDAO = HappyWriteDAO.getInstance();
	}
	
	public static Service getInstance() {
		return service;
	}
	
	
	public int memberJoin(MemberVO vo) {
		return memberDAO.memberJoin(vo); 
	}
	
	public MemberVO memberLogIn(String nickName, String password) {
		return memberDAO.memberLogIn(nickName, password);
	}
	
	public int memberLeave(String memberLogIn, String password) {
		return memberDAO.memberLeave(memberLogIn, password);
	}
	
	
	public int happyBoardWrite(HappyBoardVO vo) {
		return happyWriteDAO.happyBoardWrite(vo);
	}
}

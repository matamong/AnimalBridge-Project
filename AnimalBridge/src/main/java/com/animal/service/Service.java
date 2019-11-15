package com.animal.service;

import com.animal.dao.MemberDAO;
import com.animal.vo.MemberVO;

public class Service {
	private final MemberDAO dao;
	private static final Service service;
	
	static {
		service = new Service();
	}
	
	private Service() { 
		dao = MemberDAO.getInstance();
	}
	
	public static Service getInstance() {
		return service;
	}
	
	
	public int memberJoin(MemberVO vo) {
		return dao.memberInsert(vo); 
	}
	
	public MemberVO memberLogIn(String nickName, String password) {
		return dao.memberSelect(nickName, password);
	}
	
	public int memberLeave(String nickName) {
		return dao.memberDelete(nickName);
	}
}

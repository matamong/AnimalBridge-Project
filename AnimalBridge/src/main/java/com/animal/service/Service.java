package com.animal.service;

import java.util.ArrayList;

import com.animal.dao.MemberDAO;
import com.animal.dao.ReservationDAO;
import com.animal.vo.MemberVO;
import com.animal.vo.ReservationVO;

public class Service {
	private final MemberDAO dao;
	
	private final ReservationDAO revDao;
	
	private static final Service service;
	
	static {
		service = new Service();
	}
	
	private Service() { 
		dao = MemberDAO.getInstance();
		
		revDao= ReservationDAO.getInstance();
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
	
	
	
	//예약계시판 박보금
	public ArrayList<ReservationVO> reservationCheckAll(int year, int month, int lastday){
		return revDao.reservationCheckAll(year, month, lastday);
	}
}

package com.animal.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.animal.dao.HappyBoardDAO;
import com.animal.dao.MemberDAO;
import com.animal.dao.RecruitDAO;
import com.animal.dao.VoluntenDAO;
import com.animal.vo.HappyBoardVO;
import com.animal.vo.MemberVO;
import com.animal.vo.RecruitVO;
import com.animal.vo.VoluntenVO;

public class Service {
	private final MemberDAO memberDAO;
	private final HappyBoardDAO happyBoardDAO;
	private final VoluntenDAO vDao;
	private final RecruitDAO rDao;
	
	private static final Service service;
	
	static {
		service = new Service();
	}
	
	private Service() { 
		memberDAO = MemberDAO.getInstance();
		happyBoardDAO = HappyBoardDAO.getInstance();
		vDao = VoluntenDAO.getInstance();
		rDao = RecruitDAO.getInstance();
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
	
	
	// 헤피 게시판 - 김영우
	public int happyBoardWrite(HappyBoardVO vo) {
		return happyBoardDAO.happyBoardWrite(vo);
	}
	
	public int getHappyBoardWriterResultIdx(HappyBoardVO vo) {
		return happyBoardDAO.getHappyBoardWriterResultIdx(vo);
	}
	
	public HappyBoardVO getHappyBoardViewByIdx(int idx) {
		return happyBoardDAO.getHappyBoardViewByIdx(idx);
	}
	
	
	// 서비스 추가 - 이정민
	public int voluntenInsert(VoluntenVO vo) {
		return vDao.voluntenInsert(vo);
	}
	
	public VoluntenVO voluntenSelect(int v_no) {
		return vDao.voluntenSelect(v_no);
	}
	
	public ArrayList<VoluntenVO> voluntenList() {
		return vDao.voluntenList();
	}
	
	public int voluntenUpdate(String v_requite, int v_noshow, String v_context, Timestamp v_enddate, int v_no) {
		return vDao.voluntenUpdate(v_requite, v_noshow, v_context, v_enddate, v_no);
	}
	
	public int voluntenDelete(int v_no) {
		return vDao.voluntenDelete(v_no);
	}
	
	public int recruitInsert(RecruitVO vo) {
		return rDao.recruitInsert(vo);
	}
	
	public RecruitVO recruitSelect(int r_no) {
		return rDao.recruitSelect(r_no);
	}
	
	public ArrayList<RecruitVO> recruitList() {
		return rDao.recruitList();
	}
	
	public int recruitDelete(int r_no) {
		return rDao.recruitDelete(r_no);
	}
	
	public int recruitUpdate(int r_cnt, int r_type, int r_no) {
		return rDao.recruitUpdate(r_cnt, r_type, r_no);
	}
	
	public int getNoshowCount(String nick_name) {
		return rDao.getNoshowCount(nick_name);
	}
	
	public int noshowUpdate(String nick_name, int noshow) {
		return rDao.noshowUpdate(nick_name, noshow);
	}
}

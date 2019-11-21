package com.animal.vo;

public class RecruitVO {

	private int r_no;
	private int r_vno;
	private int r_cnt;
	private String r_nick;
	private int r_type;
	
	public RecruitVO() {};
	public RecruitVO(int r_no, int r_vno, int r_cnt, String r_nick, int r_type) {
		
		this.r_no = r_no;
		this.r_vno = r_vno;
		this.r_cnt = r_cnt;
		this.r_nick = r_nick;
		this.r_type = r_type;
		
	}
	
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getR_vno() {
		return r_vno;
	}
	public void setR_vno(int r_vno) {
		this.r_vno = r_vno;
	}
	public int getR_cnt() {
		return r_cnt;
	}
	public void setR_cnt(int r_cnt) {
		this.r_cnt = r_cnt;
	}
	public String getR_nick() {
		return r_nick;
	}
	public void setR_nick(String r_nick) {
		this.r_nick = r_nick;
	}
	public int getR_type() {
		return r_type;
	}
	public void setR_type(int r_type) {
		this.r_type = r_type;
	}
	
}

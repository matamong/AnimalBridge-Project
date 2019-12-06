package com.animal.vo;

import java.sql.Timestamp;

public class VoluntenVO {
	private int v_no;
	private String v_title;
	private int v_recruit;
	private String v_require;
	private int v_noshow;
	private int v_cidx;
	private String v_context;
	private Timestamp v_regdate;
	private Timestamp v_enddate;
	private Timestamp v_expdate;
	
	public VoluntenVO() {}
	public VoluntenVO(int v_no, String v_title, int v_recruit, String v_require, int v_noshow, int v_cidx, String v_context, Timestamp v_regdate, Timestamp v_enddate, Timestamp v_expdate) {
		this.v_no = v_no;
		this.v_title = v_title;
		this.v_recruit = v_recruit;
		this.v_require = v_require;
		this.v_noshow = v_noshow;
		this.v_cidx = v_cidx;
		this.v_context = v_context;
		this.v_regdate = v_regdate;
		this.v_enddate = v_enddate;
		this.v_expdate = v_expdate;
	}
	
	public int getV_no() {
		return v_no;
	}
	public void setV_no(int v_no) {
		this.v_no = v_no;
	}
	public String getV_title() {
		return v_title;
	}
	public void setV_title(String v_title) {
		this.v_title = v_title;
	}
	public int getV_recruit() {
		return v_recruit;
	}
	public void setV_recruit(int v_recruit) {
		this.v_recruit = v_recruit;
	}
	public String getV_require() {
		return v_require;
	}
	public void setV_require(String v_require) {
		this.v_require = v_require;
	}
	public int getV_noshow() {
		return v_noshow;
	}
	public void setV_noshow(int v_noshow) {
		this.v_noshow = v_noshow;
	}
	public int getV_cidx() {
		return v_cidx;
	}
	public void setV_cidx(int v_cidx) {
		this.v_cidx = v_cidx;
	}
	public String getV_context() {
		return v_context;
	}
	public void setV_context(String v_context) {
		this.v_context = v_context;
	}
	public Timestamp getV_regdate() {
		return v_regdate;
	}
	public void setV_regdate(Timestamp v_regdate) {
		this.v_regdate = v_regdate;
	}
	public Timestamp getV_enddate() {
		return v_enddate;
	}
	public void setV_enddate(Timestamp v_enddate) {
		this.v_enddate = v_enddate;
	}
	public Timestamp getV_expdate() {
		return v_expdate;
	}
	public void setV_expdate(Timestamp v_expdate) {
		this.v_expdate = v_expdate;
	}
	
}
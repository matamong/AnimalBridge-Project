package com.animal.vo;

public class CenterVO {

	private int center_idx;
	private String center_name;
	private String center_addr;
	private String center_phone;
	
	public CenterVO() {}
	public CenterVO(int center_idx, String center_name, String center_addr, String center_phone) {
		
		this.center_idx = center_idx;
		this.center_name = center_name;
		this.center_addr = center_addr;
		this.center_phone = center_phone;
		
	}
	
	public int getCenter_idx() {
		return center_idx;
	}
	public void setCenter_idx(int center_idx) {
		this.center_idx = center_idx;
	}
	public String getCenter_name() {
		return center_name;
	}
	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	public String getCenter_addr() {
		return center_addr;
	}
	public void setCenter_addr(String center_addr) {
		this.center_addr = center_addr;
	}
	public String getCenter_phone() {
		return center_phone;
	}
	public void setCenter_phone(String center_phone) {
		this.center_phone = center_phone;
	}
	
}

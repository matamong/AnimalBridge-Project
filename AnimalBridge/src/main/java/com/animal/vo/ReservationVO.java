package com.animal.vo;

public class ReservationVO {
	private int rev_number;
	private String rev_date;
	private String rev_time;
	private int animal_IDX;
	private int center_IDX;
	private String nick_name;
	private String phone;
	
	
	public int getRev_number() {
		return rev_number;
	}
	public void setRev_number(int rev_number) {
		this.rev_number = rev_number;
	}
	public String getRev_date() {
		return rev_date;
	}
	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}
	public String getRev_time() {
		return rev_time;
	}
	public void setRev_time(String rev_time) {
		this.rev_time = rev_time;
	}
	public int getAnimal_IDX() {
		return animal_IDX;
	}
	public void setAnimal_IDX(int animal_IDX) {
		this.animal_IDX = animal_IDX;
	}
	public int getCenter_IDX() {
		return center_IDX;
	}
	public void setCenter_IDX(int center_IDX) {
		this.center_IDX = center_IDX;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

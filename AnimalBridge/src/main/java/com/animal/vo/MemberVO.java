package com.animal.vo;

public class MemberVO {
	private String nickName;
	private String email;
	private String password;
	private String addr;
	private String phone;
	
	
	public MemberVO() { }
	public MemberVO(String nickName,
					String email,
					String password,
					String addr,
					String phone) {
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.addr = addr;
		this.phone = phone;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

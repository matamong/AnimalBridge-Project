package com.animal.vo;

public class HappyBoardVO {
	private int idx;
	private String nickName;
	private String title;
	private String content;
	private String regDate;
	private int watch;
	private int hit;
	private String img_1;
	private String img_2;
	private String img_3;
	
	
	public HappyBoardVO() { }
	
	public HappyBoardVO(int idx,
						String nickName,
						String title,
						String content,
						String regDate,
						int watch,
						int hit,
						String img_1,
						String img_2,
						String img_3) {
		this.idx = idx;
		this.nickName = nickName;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.watch = watch;
		this.hit = hit;
		this.img_1 = img_1;
		this.img_2 = img_2;
		this.img_3 = img_3;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	public int getWatch() {
		return watch;
	}
	public void setWatch(int watch) {
		this.watch = watch;
	}
	
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	public String getImg_1() {
		return img_1;
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	
	
	public String getImg_2() {
		return img_2;
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	
	
	public String getImg_3() {
		return img_3;
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
}

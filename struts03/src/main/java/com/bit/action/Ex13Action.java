package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex13Action implements Action {
	String id;
	int pw;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getPw() {
		return pw;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(id);
		System.out.println(pw);
		return Action.SUCCESS;
	}

}

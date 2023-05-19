package com.bit.controller;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("스트럿츠 액션");
		return "success";
	}

}

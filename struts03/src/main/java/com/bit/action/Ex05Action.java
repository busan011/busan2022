package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex05Action implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("ex05");
		return Action.SUCCESS;
	}

}

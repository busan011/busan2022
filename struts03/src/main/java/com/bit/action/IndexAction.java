package com.bit.action;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("index action");
		return Action.SUCCESS;
		
	}

}

package com.jsyunsi.mobile_manager.main;

import com.jsyunsi.mobile_manager.services.ListenService;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("开始监听...");
		new ListenService().start();
	}
}

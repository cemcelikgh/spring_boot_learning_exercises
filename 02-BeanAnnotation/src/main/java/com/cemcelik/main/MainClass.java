package com.cemcelik.main;

import com.cemcelik.services.LoginService;

public class MainClass {

	public static void main(String[] args) {

		LoginService loginService = new LoginService();
		loginService.login();

	}

}

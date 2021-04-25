package com.mcd.test;

import org.testng.annotations.Test;

import com.mcd.components.Login;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("start");
		Login login = new Login(driver);
		login.navigateTo().enterMobileNumber()
		.clickGenerateOTPButton()
		.enterOTP()
		.clickLoginsButton();

	}
}

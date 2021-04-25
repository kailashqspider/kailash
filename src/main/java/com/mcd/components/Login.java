package com.mcd.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.framework.Constants;
import com.mcd.framework.ReusableLibrary;

public class Login extends ReusableLibrary {

	private WebDriver driver;
	private By inputMobileNumber = By.xpath("//input[contains(@id,'name-login')]");
	private By btnGenerateOTP = By.xpath("//button[contains(@id,'gntateOTP')]");
	private By btnLogin = By.xpath("(//button[contains(@type,'submit')])[1]");

	public Login(WebDriver webDriver) {
		this.driver = webDriver;
	}

	public Login navigateTo() {
		driver.get(Constants.BASE_URL + "/ptredmc/web/citizen/info");
		return this;
	}

	public Login enterMobileNumber() {
		setValue(driver, inputMobileNumber, Constants.CITIZEN_MOBILE_NUMBER);
		return this;
	}

	public Login clickGenerateOTPButton() {
		clickCustomize(driver, btnGenerateOTP);
		return this;
	}

	public Login enterOTP() throws InterruptedException {
		System.out.println("Please Enter your OTP on input field+++++++++++++++++++++++++");
		Thread.sleep(45000);
		return this;
	}

	public Login clickLoginsButton() throws InterruptedException {
		clickCustomize(driver, btnLogin);
		Thread.sleep(4000);
		return this;
	}

}

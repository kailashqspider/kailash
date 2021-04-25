package com.mcd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void launchBrower(){
		System.setProperty("webdriver.chrome.driver", "D:/Kails/Workspace3/com.mcd/src/test/resources/drivers/chromedriver.exe");
		 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrower(){
		 driver.quit();
		
	}

}

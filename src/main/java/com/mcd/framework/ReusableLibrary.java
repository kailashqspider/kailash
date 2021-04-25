package com.mcd.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReusableLibrary {

	// wait for page to finish loading
	public void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = null;
		pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	// wait for page Title
	public void waitforpageTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
	}

	// reload Page
	public void reloadPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// find element
	public WebElement findElement(WebDriver driver, By elementBy) {
		return driver.findElement(elementBy);
	}

	// set Value in DropDown List
	public void setValueDropDownByValue(WebDriver driver, By elementBy, String value) {
		new Select(findElement(driver, elementBy)).selectByValue(value);
	}

	// enter value into input field
	public void setValue(WebDriver driver, By elementBy, String value) {
		WebElement webElement = findElement(driver, elementBy);
		webElement.click();
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(value);
	}

	// verify Page Title
	public void verifyPageTitle(WebDriver driver, String partialTitle) {
		waitForPageToLoad(driver);
		Assert.assertEquals(driver.getTitle(), partialTitle);
	}

	// wait for element clickable
	public void waitForElementClickable(WebDriver driver, By expElement) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(expElement));
	}

	// click Customize
	public void clickCustomize(WebDriver driver, By element) {
		waitForElementClickable(driver, element);
		driver.findElement(element).click();
	}

	// click Customize
	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
		waitForPageToLoad(driver);
	}

	// click Customize
	public void navigateToCustmUrl(WebDriver driver, String endPointUrl) {
		driver.get(Constants.BASE_URL+endPointUrl);
	}
}

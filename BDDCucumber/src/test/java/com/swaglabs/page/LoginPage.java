package com.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// created the variables by using By return type
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By errorMessage = By.xpath("//h3[@data-test='error']");

	public void login(String Username, String Password) {

		driver.findElement(username).sendKeys(Username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(loginBtn).click();
	}

	public void verifyLoginErrorMessage(String ExpectedMessage) {

		String actualText = driver.findElement(errorMessage).getText();
		
		
		Assert.assertEquals(actualText, ExpectedMessage, "The error message is not matching.");
		

	}	

}

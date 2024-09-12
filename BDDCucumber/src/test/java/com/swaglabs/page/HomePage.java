package com.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	
	private By product = By.xpath("//div[@class=\"product_label\"]");
	private By menu = By.xpath("//button[text()=\"Open Menu\"]");
	private By addtocart =By.xpath("//a[@class=\"shopping_cart_link fa-layers fa-fw\"]");
	private By name =By.xpath("//select[@class=\"product_sort_container\"]");
	
	public void homeTitle()
	
	{   
		
		String actualText=driver.findElement(product).getText();
		String expectedText="Products";

		Assert.assertEquals(actualText, expectedText,"user didnt navigate to homepage ");
	}
	

}

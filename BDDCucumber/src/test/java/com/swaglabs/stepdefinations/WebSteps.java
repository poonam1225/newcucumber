package com.swaglabs.stepdefinations;

import com.swaglabs.utilities.ExcelReader;
import com.swaglabs.utilities.Readconfig;

import org.openqa.selenium.WebDriver;

import com.swaglabs.page.HomePage;
import com.swaglabs.page.LoginPage;

import io.cucumber.java.en.*;

public class WebSteps  {
 
	WebDriver driver=Baseclass.driver;
	Readconfig readconfig=new Readconfig();
	String url=readconfig.getbaseurl();
	String browser = readconfig.getbrowser();
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
    String tcid;
	
	@Given("user launches the url")
	public void user_launches_the_url(){
		driver.get(url);
	}

	@When("user enters {string}")
	public void user_enters(String TCID) {
		tcid=TCID;
	  String username= ExcelReader.readExcel("User_Data", TCID, "Username");
	  String password=ExcelReader.readExcel("User_Data", TCID, "Password");
	  lp.login(username, password);
		
	}

	
	@Then("user verifies login is successful")
	public void user_verifies_login_is_successful() {
		hp.homeTitle();
		
	}

	@Then("user verifies error message")
	public void user_verifies_error_message() {
		
		String ErrorMessage=ExcelReader.readExcel("User_Data", tcid, "Verify text");
	    lp.verifyLoginErrorMessage(ErrorMessage);
	    
	    
	}



}

package com.swaglabs.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.swaglabs.utilities.Readconfig;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	Readconfig readconfig=new Readconfig();
	String url=readconfig.getbaseurl();
	String browser=readconfig.getbrowser();
    //WriteExcel write=new WriteExcel();
	
	public static WebDriver driver;
	
	
	@Before
	public void setup()
	{ 
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		default:
			driver=null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@AfterStep
	public void runAfterStep(Scenario scenario) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			TakesScreenshot ts= (TakesScreenshot)driver;
			final byte[] screenshot= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "taken the screenshot after the step "+ scenario.getName());
		
			System.out.println("I will run after each step.");

	}
	
	
	  @After
	 
	  public void teardown() 
	  { 
		  driver.close();
		  //driver.quit();
		  
	  }
	 


}

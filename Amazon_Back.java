package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Back {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement backtop = driver.findElement(By.xpath("//span[@class=\"navFooterBackToTopText\"]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", backtop);
		List<WebElement> links = driver.findElements(By.xpath("//div[text()=\"Make Money with Us\"]//following::ul//li//a[@class=\"nav_a\"]"));
		for(WebElement df:links)
		{
		 String link =df.getText();
		 if(link.equals("Your Account"))
		 {
			continue;
		 }
		 else
		 {
			 System.out.println(link);
		 }
			
		}
		
		
		
		
	}

}

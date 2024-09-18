
//file upload selenium code using robot class
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

import  java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;


public class FileUpload {
	public static void main(String[] args) throws AWTException, InterruptedException  {
		
	WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	  driver.get("https://www.ilovepdf.com/pdf_to_word");
	 
	  WebElement pick = driver.findElement(By.id("pickfiles"));
	       pick.click();
	   selectFile("C:\\Users\\Poonam\\OneDrive\\Documents\\Amol_resume.pdf");
	 
	   WebElement convertToWordBtn = driver.findElement(By.id("processTask"));
	   assertTrue(convertToWordBtn.isDisplayed());
	 
	   
	  WebElement button = driver.findElement(By.xpath("//button[@id=\"processTask\"]"));
	  button.click();
	  Thread.sleep(1000);
	  
	  downloadFile();
	   
	   
	   //C:\Users\Poonam\OneDrive\Documents\Amol_resume.pdf
	  // driver.quit();

}
	public static void selectFile(String path) throws AWTException {
		   StringSelection strSelection = new StringSelection(path);
		   Clipboard clipboard = Toolkit.getDefaultToolkit()
		       .getSystemClipboard();
		   clipboard.setContents(strSelection, null);
		 
		   Robot robot = new Robot();
		 
		   robot.delay(2000);
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.delay(4000);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		}
	
	public static void downloadFile(){
		
		ChromeOptions options =new ChromeOptions();
		HashMap<String,Object> chromePref=new HashMap<String,Object>();
		chromePref.put("profile.default_content_settings.popyps",0);
		String downloadFilePath=System.getProperty("C:\\Users\\Poonam\\eclipse-workspace\\practice");
		options.setExperimentalOption("prefs", chromePref);
		
	}
		
	}



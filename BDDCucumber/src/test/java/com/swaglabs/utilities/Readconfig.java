package com.swaglabs.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
    Properties pro;
	
	String path="C:\\Users\\Poonam\\eclipse-workspace\\BDDCucumber\\TestData\\config.properties";
	
	public Readconfig()
	{
	try{
		pro=new Properties();
		FileInputStream fs= new FileInputStream(path);
		pro.load(fs);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	public String getbaseurl()
	{
	 String url	=pro.getProperty("baseurl");
	 if(url !=null)
	 {
	 return url;
	 
	 }
	 else
	 {
		 throw new RuntimeException("URL is not specified in config file");
	 }
	}
	
	public String getbrowser()
	{
	 String browser	=pro.getProperty("browser");
	 if(browser !=null)
	 {
	 return browser;
	 
	 }
	 else
	 {
		 throw new RuntimeException("browser is not specified in config file");
	 }
	}
}





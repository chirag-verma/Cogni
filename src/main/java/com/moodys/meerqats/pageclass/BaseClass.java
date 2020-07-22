package com.moodys.meerqats.pageclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	
	public Properties prop;
public JavascriptExecutor Js;
	@BeforeClass
	public  void Base() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Users/VermaC/git/MeerQATS/Drivers/chromedriver.exe");
		/* Launching the browser? */
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");
		
		 Js=  (JavascriptExecutor)driver;
		 FileInputStream ip = new FileInputStream("D:\\Users/VermaC/git/MeerQATS1/Config.properties");
		  prop = new Properties();
		
		 
		 prop.load(ip);
		 
		 
		 
	}

}

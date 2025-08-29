package com.qa.test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Prop {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
//		Properties prop=new Properties();
//		FileInputStream fis=new FileInputStream("/Users/gyaneshkamal/eclipse-workspace/August_Selenium_Session/src/config/config.properties");
//		prop.load(fis);
//		//String url = prop.getProperty("url");
//		//System.out.println(url);
		Util u=new Util(driver);
		
		System.out.println(u.getProperty("username"));
		String browserName=u.getProperty("browser");
		if(browserName.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("safari")) {
			 driver=new SafariDriver();
		}
		//WebDriver driver=new ChromeDriver();
		driver.get(u.getProperty("url"));
		driver.findElement(By.name("q")).sendKeys(u.getProperty("username"));
	}
}

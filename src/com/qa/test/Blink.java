package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Blink {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	WebElement search = driver.findElement(By.name("q"));
	blinkElement(search);
	WebElement gmail = driver.findElement(By.linkText("Gmail"));
	blinkElement(gmail);
	WebElement images = driver.findElement(By.linkText("Images"));
	blinkElement(images);
	

}
	
	 public static void blinkElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // get original border style
	        String originalStyle = element.getAttribute("style");

	        for (int i = 0; i < 5; i++) {
	            // highlight with red border
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
	                             element, "border: 3px solid red;");

	            sleep(200);

	            // revert back to original style
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
	                             element, originalStyle);

	            sleep(200);
	        }
	    }

	    private static void sleep(int millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
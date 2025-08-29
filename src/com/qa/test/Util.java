package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Util {
	WebDriver driver;// global variable
	Properties prop;
	Actions actions;

	public Util(WebDriver driver) {
		this.driver = driver;
		// this.prop = prop;
		this.init_property();
		// this.actions=actions;
	}

	public String title() {

		return driver.getTitle();

	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.sendKeys(value);
	}

	public void selectLisbox(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		highlightElement(element);
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String[] colors = { "red", "green", "blue", "orange", "purple" };

		for (String color : colors) {
			js.executeScript("arguments[0].style.border='3px solid " + color + "'", element);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // wait half a second
		}

		// reset to original
		js.executeScript("arguments[0].style.border=''", element);
	}

	public Properties init_property() {
		prop = new Properties();
		try {
			// FileInputStream fis = new FileInputStream("./config/config.properties");
			prop.load(getClass().getClassLoader().getResourceAsStream("./config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
	}

	public String takeScreenshot(String fileName) {
		// String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new
		// java.util.Date());
		// String screenshotName = fileName + "_" + timestamp + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/snap/" + System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(src, new File(dest));
			System.out.println("Screenshot saved at: " + dest);
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}

		return dest;
	}

	public String takeElementScreenshot(WebElement element, String fileName) {
		// String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new
		// java.util.Date());
		// String screenshotName = fileName + "_" + timestamp + ".png";

		File src = element.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/snap/" + System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(src, new File(dest));
			System.out.println("Element screenshot saved at: " + dest);
		} catch (IOException e) {
			System.out.println("Failed to save element screenshot: " + e.getMessage());
		}

		return dest;
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismisstAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeysOnAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
}

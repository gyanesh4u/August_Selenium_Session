package com.qa.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkImages {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken"); // Example page

        // Check links
        checkLinks(driver);

        // Check images
        checkImages(driver);

        driver.quit();
    }

    // Method to check all links
    public static void checkLinks(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("🔗 Total Links Found: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("⚠️ Skipping empty link");
                continue;
            }
            verifyUrl(url, "Link");
        }
    }

    // Method to check all images
    public static void checkImages(WebDriver driver) {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("🖼️ Total Images Found: " + images.size());

        for (WebElement img : images) {
            String url = img.getAttribute("src");

            if (url == null || url.isEmpty()) {
                System.out.println("⚠️ Skipping empty image src");
                continue;
            }

            // First: backend check (HTTP response)
            verifyUrl(url, "Image");

            // Second: frontend check (is it rendered?)
            Boolean isDisplayed = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0", img);

            if (isDisplayed) {
                System.out.println("✅ Image rendered correctly: " + url);
            } else {
                System.out.println("❌ Image not displayed/rendered: " + url);
            }
        }
    }
    private static void verifyUrl(String url, String type) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(5000);
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode >= 400) {
                System.out.println("❌ Broken " + type + ": " + url + " | Status Code: " + responseCode);
            } else {
                System.out.println("✅ Valid " + type + ": " + url + " | Status Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("⚠️ Exception while checking " + type + ": " + url + " | " + e.getMessage());
        }
}
}
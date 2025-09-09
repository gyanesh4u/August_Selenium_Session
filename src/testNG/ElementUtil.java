package testNG;


import java.io.File;

// change as needed

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * ElementUtil - handy utility methods for interacting with WebElements
 * - Uses WebDriverWait (explicit waits) with sensible defaults
 * - Provides JS fallback click, retry click, scroll into view, selects, hover, etc.
 */
public class ElementUtil {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);
    private final Duration POLLING_INTERVAL = Duration.ofMillis(200);

    public ElementUtil(WebDriver driver) {
        this(driver, Duration.ofSeconds(15));
    }

    public ElementUtil(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        this.wait.pollingEvery(POLLING_INTERVAL);
        this.wait.ignoring(NoSuchElementException.class);
        this.wait.ignoring(StaleElementReferenceException.class);
    }

    /* ---------------- Basic find / read operations ---------------- */

    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    public String getAttribute(By locator, String attr) {
        return find(locator).getAttribute(attr);
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    /* ---------------- Actions ---------------- */

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void jsClick(By locator) {
        WebElement el = find(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void sendKeys(By locator, CharSequence... keys) {
        WebElement el = waitForVisible(locator);
        el.clear();
        el.sendKeys(keys);
    }

    public void clear(By locator) {
        WebElement el = find(locator);
        el.clear();
    }

    public void hoverOver(By locator) {
        WebElement el = waitForVisible(locator);
        new Actions(driver).moveToElement(el).perform();
    }

    public void doubleClick(By locator) {
        WebElement el = waitForVisible(locator);
        new Actions(driver).doubleClick(el).perform();
    }

    public void rightClick(By locator) {
        WebElement el = waitForVisible(locator);
        new Actions(driver).contextClick(el).perform();
    }

    /* ---------------- Wait helpers ---------------- */

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForTextToBe(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    /**
     * Generic fluent wait for a custom condition
     */
    public <R> R waitForCondition(Function<? super WebDriver, R> condition, Duration timeout) {
        FluentWait<WebDriver> fw = new FluentWait<>(driver)
            .withTimeout(timeout)
            .pollingEvery(POLLING_INTERVAL)
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);
        return fw.until(condition);
    }

    /* ---------------- Robust interactions ---------------- */

    /**
     * Try clicking element with retries. Tries normal click, then JS click if needed.
     */
    public void clickWithRetries(By locator, int attempts, Duration betweenAttempts) {
        int tries = 0;
        while (tries < attempts) {
            try {
                click(locator);
                return;
            } catch (WebDriverException e1) {
                try {
                    jsClick(locator);
                    return;
                } catch (WebDriverException e2) {
                    tries++;
                    try {
                        Thread.sleep(betweenAttempts.toMillis());
                    } catch (InterruptedException ignored) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        // final attempt to throw a helpful exception
        click(locator);
    }

    /**
     * Scroll element into view (alignToTop: true -> top of viewport)
     */
    public void scrollIntoView(By locator, boolean alignToTop) {
        WebElement el = find(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(arguments[1]);", el, alignToTop);
    }

    /**
     * Scroll by pixels
     */
    public void scrollBy(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
    }

    /* ---------------- Select helpers ---------------- */

    public void selectByVisibleText(By locator, String visibleText) {
        Select sel = new Select(waitForVisible(locator));
        sel.selectByVisibleText(visibleText);
    }

    public void selectByValue(By locator, String value) {
        Select sel = new Select(waitForVisible(locator));
        sel.selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        Select sel = new Select(waitForVisible(locator));
        sel.selectByIndex(index);
    }

    /* ---------------- Utility / Page helpers ---------------- */

    public boolean waitForPageLoaded(Duration timeout) {
        WebDriverWait w = new WebDriverWait(driver, timeout);
        return w.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Retryable find with timeout (alternative to waitForVisible)
     */
    public WebElement retryingFind(By locator, Duration timeout) {
        long end = System.currentTimeMillis() + timeout.toMillis();
        while (System.currentTimeMillis() < end) {
            try {
                WebElement el = driver.findElement(locator);
                if (el != null) return el;
            } catch (NoSuchElementException ignored) {}
            try {
                Thread.sleep(POLLING_INTERVAL.toMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        throw new NoSuchElementException("Element not found within " + timeout.getSeconds() + " seconds: " + locator);
    }

    /**
     * Simple safe get list size
     */
    public int count(By locator) {
        try {
            List<WebElement> els = findAll(locator);
            return els.size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    /* ---------------- Screenshot helper (optional) ---------------- */

    public byte[] takeScreenshotBytes() {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

    public void takeScreenshotToFile(String path) {
        if (driver instanceof TakesScreenshot) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                java.nio.file.Files.copy(src.toPath(), java.nio.file.Paths.get(path));
            } catch (Exception e) {
                throw new RuntimeException("Failed to save screenshot to " + path, e);
            }
        } else {
            throw new UnsupportedOperationException("Driver does not support screenshots");
        }
    }
}


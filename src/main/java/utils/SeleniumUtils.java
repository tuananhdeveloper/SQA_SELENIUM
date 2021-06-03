package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ObjectInputFilter;

public class SeleniumUtils {

    public static void WaitUntilVisible(WebDriver driver, WebElement element) {
        waitForCondition(driver, ExpectedConditions.visibilityOf(element), 10);
    }
    public static void waitBy(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    private static void waitForCondition(WebDriver driver, ExpectedCondition condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }
    public static WebElement waitForElementToClickable(WebDriver driver, WebElement element) {
        waitForCondition(driver, ExpectedConditions.elementToBeClickable(element), 10);
        return element;
    }
}
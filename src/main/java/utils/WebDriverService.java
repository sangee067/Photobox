package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverService {

    public static WebDriver driver;

    protected void waitForElement(WebElement element, int sec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, sec);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void enterValueInTextField(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    protected void clickOnElement(WebElement element, String elementText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (elementText != null) {
            if (element.getText().equalsIgnoreCase(elementText) || element.getText().contains(elementText)) {
                element.click();
            }
        } else {
            element.click();
        }
    }

}

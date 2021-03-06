package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void setText(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Dropdown Functions
     */
    public void selectDropdownByIndex(By locator, int index) {
        WebElement dropdownElement = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    public void selectDropDownByValue(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    public void selectDropDownByText(By locator, String text) {
        WebElement dropdownElement = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

    /**
     * CheckBox
     */
    public void checkOnCheckbox(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}

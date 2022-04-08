package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        return driver.getCurrentUrl().toString();
    }
}

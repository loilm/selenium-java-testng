package pages;

import commons.CommonPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptPage {
    private WebDriver driver;
    private CommonPage commonPage;
    private WebDriverWait wait;
    private Alert alert;

    By clickForJSAlertBtn = By.xpath("//button[.='Click for JS Alert']");
    By clickForJSConfirmBtn = By.xpath("//button[.='Click for JS Confirm']");
    By clickForJSPromptBtn = By.xpath("//button[.='Click for JS Prompt']");
    By resultTxt = By.id("result");

    public JavaScriptPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickForJSAlert() {
        commonPage.clickElement(clickForJSAlertBtn);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickForJSConfirm(String action) {
        commonPage.clickElement(clickForJSConfirmBtn);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        if (action.trim().equalsIgnoreCase("accept")) {
            alert.accept();
        } else if (action.trim().equalsIgnoreCase("dismiss")) {
            alert.dismiss();
        }
    }

    public void clickForJSPrompt(String enterText, String action) {
        commonPage.clickElement(clickForJSPromptBtn);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(enterText);
        if (action.trim().equalsIgnoreCase("accept")) {
            alert.accept();
        } else if (action.trim().equalsIgnoreCase("dismiss")) {
            alert.dismiss();
        }
    }

    public void verifyResult(String expectedResult) {
        Assert.assertEquals(commonPage.getText(resultTxt), expectedResult);
    }
}

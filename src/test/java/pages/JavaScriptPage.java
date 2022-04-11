package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JavaScriptPage {
    private WebDriver driver;
    private CommonPage commonPage;
    By clickForJSAlertBtn = By.xpath("//button[.='Click for JS Alert']");
    By clickForJSConfirmBtn = By.xpath("//button[.='Click for JS Confirm']");
    By clickForJSPromptBtn = By.xpath("//button[.='Click for JS Prompt']");
    By resultTxt = By.id("result");

    public JavaScriptPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void clickForJSAlert() {
        commonPage.clickElement(clickForJSAlertBtn);
        driver.switchTo().alert().accept();
    }

    public void clickForJSConfirm(String action) {
        commonPage.clickElement(clickForJSConfirmBtn);
        if (action.trim().equalsIgnoreCase("accept")) {
            driver.switchTo().alert().accept();
        } else if (action.trim().equalsIgnoreCase("dismiss")) {
            driver.switchTo().alert().dismiss();
        }
    }

    public void clickForJSPrompt(String enterText, String action) {
        commonPage.clickElement(clickForJSPromptBtn);
        driver.switchTo().alert().sendKeys(enterText);
        if (action.trim().equalsIgnoreCase("accept")) {
            driver.switchTo().alert().accept();
        } else if (action.trim().equalsIgnoreCase("dismiss")) {
            driver.switchTo().alert().dismiss();
        }
    }

    public void verifyResult(String expectedResult) {
        Assert.assertEquals(commonPage.getText(resultTxt), expectedResult);
    }
}

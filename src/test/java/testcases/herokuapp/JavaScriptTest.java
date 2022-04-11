package testcases.herokuapp;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.JavaScriptPage;

public class JavaScriptTest extends CommonTest {
    private WebDriver driver;
    private JavaScriptPage javaScriptPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        javaScriptPage = new JavaScriptPage(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void clickForJSAlertTest() {
        javaScriptPage.clickForJSAlert();
        javaScriptPage.verifyResult("You successfully clicked an alert");
    }

    @Test
    public void acceptForJSConfirmTest() {
        javaScriptPage.clickForJSConfirm("accept");
        javaScriptPage.verifyResult("You clicked: Ok");
    }

    @Test
    public void dismissForJSConfirmTest() {
        javaScriptPage.clickForJSConfirm("dismiss");
        javaScriptPage.verifyResult("You clicked: Cancel");
    }

    @Test
    public void acceptForJSPromptTest() {
        javaScriptPage.clickForJSPrompt("Selenium", "accept");
        javaScriptPage.verifyResult("You entered: Selenium");
    }

    @Test
    public void dismissForJSPromptTest() {
        javaScriptPage.clickForJSPrompt("Selenium", "dismiss");
        javaScriptPage.verifyResult("You entered: null");
    }
}

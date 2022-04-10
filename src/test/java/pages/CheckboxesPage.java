package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckboxesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;
    By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void checkOnCheckbox1AndVerify() {
        commonPage.checkOnCheckbox(checkbox1);
        Assert.assertTrue(driver.findElement(checkbox1).isSelected());
    }

    public void checkOnCheckbox2AndVerify() {
        commonPage.checkOnCheckbox(checkbox2);
        Assert.assertFalse(driver.findElement(checkbox2).isSelected());
    }
}

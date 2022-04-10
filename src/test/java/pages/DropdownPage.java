package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DropdownPage {
    private WebDriver driver;
    private CommonPage commonPage;
    By dropdown = By.id("dropdown");
    By option1 = By.xpath("//select[@id='dropdown']/option[2]");
    By option2 = By.xpath("//select[@id='dropdown']/option[3]");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public void selectOption1() {
        commonPage.selectDropDownByValue(dropdown, "1");
        Assert.assertTrue(driver.findElement(option1).isSelected());
    }

    public void selectOption2() {
        commonPage.selectDropDownByText(dropdown,"Option 2");
        Assert.assertTrue(driver.findElement(option2).isSelected());
    }
}

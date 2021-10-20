package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDashboard extends BasePage {

    public AdminDashboard(WebDriver webDriver) {
        super(webDriver);
    }

    SignUpPage signUpPage = new SignUpPage(webDriver);

    @FindBy(xpath = "//div[@class='sidebar-wrapper']//a[contains(@href,'dashboard')]//p")
    private WebElement dashboard;

    @FindBy(xpath = "//div[@class='sidebar-wrapper']//a[contains(@href,'bands')]//p")
    private WebElement bands;

    private String bandEdit =
            "//table/tbody/tr/td[contains(text(),'"
                    + signUpPage.randomBandName
                    + "')]/parent::*//td[3]/button";

    public void checkBandChanges() {
        clickOnElement(bands);
        clickOnElement(bandEdit);
    }
}

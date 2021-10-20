package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id='hs-eu-confirmation-button']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement login;

    @FindBy(xpath = "//button[contains(text(),'Sign-up')]")
    private WebElement signUp;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage goToLogInPage() {
        acceptCookies.click();
        waitTillElementIsVisible(login);
        login.click();
        return new LoginPage(webDriver);
    }

    public SignUpPage goToSignUpPage() {
        acceptCookies.click();
        waitTillElementIsVisible(signUp);
        signUp.click();
        return new SignUpPage(webDriver);
    }
}

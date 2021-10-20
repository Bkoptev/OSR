package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//a[@class='signup_link']")
    private WebElement signUp;

    @FindBy(xpath = "//button[@id='next']")
    WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Log in using email and password
     *
     * @return next page
     */
    public void logIn(String email, String pass) throws InterruptedException {
        waitTillElementIsClickable(signInButton, 5);
        username.sendKeys(email);
        password.sendKeys(pass);
        signInButton.click();
        Thread.sleep(3000);
    }
}

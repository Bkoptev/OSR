package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected String randomEmail = "Bogdan.Koptev+" + random4Digits() + "@jumar-technology.com";
    protected String randomPassword = "Test!" + random4Digits();
    protected String randomName = "Bogdan" + random4Digits();
    protected String randomBandName = "BogdanBand" + random4Digits();

    @FindBy(
            xpath =
                    "//div[@class='buttons']//button[@class='signup-button' and contains(text(),'User')]")
    private WebElement signUpAsUser;

    @FindBy(
            xpath =
                    "//div[@class='buttons']//button[@class='signup-button' and contains(text(),'Artist')]")
    private WebElement signUpAsArtist;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='newPassword']")
    private WebElement newPassword;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='reenterPassword']")
    private WebElement reenterPassword;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='extension_BandName']")
    private WebElement bandName;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='givenName']")
    private WebElement givenName;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='surname']")
    private WebElement surname;

    @FindBy(xpath = "//form[@id='attributeVerification']//input[@id='displayName']")
    private WebElement userName;

    @FindBy(xpath = "//button[@id='continue']")
    private WebElement createNewButton;

    public void registerAsUser() {
        clickOnElement(signUpAsUser, 5);
        waitTillElementIsVisible(emailField);
        emailField.sendKeys(randomEmail);
        newPassword.sendKeys(randomPassword);
        reenterPassword.sendKeys(randomPassword);
        userName.sendKeys(randomName);
        clickOnElement(createNewButton);
    }

    public void registerAsArtist() {
        clickOnElement(signUpAsArtist, 5);
        waitTillElementIsVisible(emailField);
        emailField.sendKeys(randomEmail);
        log("randomly generated email - " + randomEmail);
        newPassword.sendKeys(randomPassword);
        log("randomly generated password - " + randomPassword);
        reenterPassword.sendKeys(randomPassword);
        bandName.sendKeys(randomBandName);
        log("randomly generated band name - " + randomBandName);
        givenName.sendKeys(randomBandName);
        surname.sendKeys(randomBandName);
        clickOnElement(createNewButton);
    }
}

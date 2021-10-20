package osr.net.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import osr.net.utils.YamlFile;
import osr.net.utils.YamlParser;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='PaymentHeader']/div[contains(@class,'Text')]")
    private WebElement payWithCard;

    @FindBy(xpath = "//input[@id='cardNumber']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='cardExpiry']")
    private WebElement cardExpiry;

    @FindBy(xpath = "//input[@id='cardCvc']")
    private WebElement cardCvc;

    @FindBy(xpath = "//input[@id='billingName']")
    private WebElement billingName;

    @FindBy(xpath = "//select[@id='billingCountry']")
    private WebElement billingCountry;

    @FindBy(xpath = "//select[@id='billingCountry']/option[2]")
    private WebElement billingCountryAfganistan;

    @FindBy(xpath = "//div[@class='SubmitButton-CheckmarkIcon']")
    private WebElement submitPay;

    @FindBy(
            xpath =
                    "//div[contains(@class,'container-lg upsell-popup')]//span[contains(text(),'VISIT')]")
    private WebElement visitStore;

    private String cardNum = "4242424242424242";
    private String cardDate = "1025";
    private String cardCVV = "111";
    private String cardName = "Bogdan Test";

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void cardFillOut() throws IOException {
        YamlFile yamlData = YamlParser.getYamlData();
        email.sendKeys(yamlData.getUserLogin());
        cardNumber.sendKeys(cardNum);
        cardExpiry.sendKeys(cardDate);
        cardCvc.sendKeys(cardCVV);
        billingName.sendKeys(cardName);
        billingCountryAfganistan.click();
    }

    public MyRequests myRequests() throws IOException {
        submitPay.click();
        return new MyRequests(webDriver);
    }
}

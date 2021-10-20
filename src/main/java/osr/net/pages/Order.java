package osr.net.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import osr.net.utils.YamlFile;
import osr.net.utils.YamlParser;

public class Order extends BasePage {

    public String usedNameInOrder = "BogdanTest" + random4Digits();

    @FindBy(xpath = "//button/span[contains(text(),'Proceed')]")
    private WebElement proceedToPayment;

    @FindBy(xpath = "//span[contains(text(),'Name')]/following-sibling::input")
    private WebElement name;

    @FindBy(xpath = "//span[contains(text(),'Email')]/following-sibling::input")
    private WebElement recepientsEmail;

    @FindBy(xpath = "//span[contains(text(),'Track')]/following-sibling::input")
    private WebElement track;

    @FindBy(xpath = "//select[@name='AspectRatio']")
    private WebElement aspect;

    @FindBy(xpath = "//select[@name='Pronoun']")
    private WebElement pronoun;

    @FindBy(xpath = "//select[@name='Occassion']")
    private WebElement occasion;

    @FindBy(xpath = "//span[contains(text(),'Average')]/following-sibling::input")
    private WebElement responceTime;

    @FindBy(xpath = "//span[contains(text(),'Fee')]/following-sibling::input")
    private WebElement fee;

    @FindBy(xpath = "//span[contains(text(),'Instructions')]/following-sibling::textarea")
    private WebElement instructions;

    @FindBy(xpath = "//select[@name='AspectRatio']/option[2]")
    private WebElement landscapeMode;

    @FindBy(xpath = "//select[@name='Pronoun']/option[2]")
    private WebElement pronounShe;

    @FindBy(xpath = "//select[@name='Occassion']/option[2]")
    private WebElement occasionBirthday;

    @FindBy(xpath = "//div[@class='SubmitButton-CheckmarkIcon']")
    private WebElement submitPay;

    public Order(WebDriver webDriver) {
        super(webDriver);
    }

    public void completeRequestForm() throws IOException {

        name.sendKeys(usedNameInOrder);
        YamlFile yamlData = YamlParser.getYamlData();
        recepientsEmail.sendKeys(yamlData.getUserLogin());
        track.sendKeys("TestTrack");
        aspect.click();
        landscapeMode.click();
        pronoun.click();
        pronounShe.click();
        occasion.click();
        occasionBirthday.click();
        proceedToPayment.click();
        instructions.sendKeys("Test instructions bla bla bla");
    }

    public CheckoutPage checkoutPage() {
        proceedToPayment.click();
        return new CheckoutPage(webDriver);
    }
}

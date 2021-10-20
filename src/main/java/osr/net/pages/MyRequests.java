package osr.net.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyRequests extends BasePage {

    @FindBy(
            xpath =
                    "//div[contains(@class,'container-lg upsell-popup')]//a[@class='decline-request']")
    private WebElement cancelButton;

    @FindBy(
            xpath =
                    "//div[contains(@class,'container-lg upsell-popup')]//span[contains(text(),'VISIT')]")
    private WebElement visitStore;

    @FindBy(xpath = "//span[contains(text(),'My Requests')]")
    private WebElement myRequests;

    @FindBy(xpath = "//table//tbody/tr[last()]/td[1]")
    private WebElement lastRequestDate;

    @FindBy(xpath = "//table//tbody/tr[last()]/td[2]")
    private WebElement lastRequestArtist;

    @FindBy(xpath = "//table//tbody/tr[last()]/td[3]")
    private WebElement lastRequestRecipient;

    public MyRequests(WebDriver webDriver) {
        super(webDriver);
    }

    public void closeRequestPage() {
        cancelButton.click();
    }

    public void openRequests() {
        myRequests.click();
    }

    public void recentRequestCheck(String artistNameInOrder, String recipient) {
        waitTillElementIsVisible(lastRequestDate);
        waitTillElementIsVisible(lastRequestArtist);
        waitTillElementIsVisible(lastRequestRecipient);
        String currentDate =
                new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        try {
            Assert.assertEquals(
                    "Value of date is not equal", currentDate, lastRequestDate.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(
                    "Value of artist name is not equal",
                    artistNameInOrder,
                    lastRequestArtist.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(
                    "Value of recipient name is not equal",
                    recipient,
                    lastRequestRecipient.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

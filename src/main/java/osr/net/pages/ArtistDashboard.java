package osr.net.pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtistDashboard extends BasePage {


    @FindBy(xpath = "//h3[@class='change-moderation-message' and contains(text(),'Your changes')]")
    private WebElement approvalText;

    @FindBy(xpath = "//label[@class='clickable-label' and @for='profile-picture']//i")
    private WebElement editProfilePicture;

    @FindBy(xpath = "//label[@for='profile-cropper']//i")
    private WebElement confirmProfilePicture;

    @FindBy(xpath = "//label[@class='clickable-label' and @for='band-picture']//i")
    private WebElement editArtistPicture;

    @FindBy(xpath = "//label[@for='band-cropper']//i")
    private WebElement confirmArtistPicture;

    @FindBy(xpath = "//input[contains(@placeholder,'Search genres')]")
    private WebElement searchGenres;

    @FindBy(xpath = "//div[@role='listbox']//span[1]")
    private WebElement rockGenre;

    @FindBy(xpath = "//textarea[@name='bio']")
    private WebElement artistBio;

    @FindBy(xpath = "//input[@type='number' and contains(@class,'input-fee')]")
    private WebElement videoPrice;

    @FindBy(xpath = "//input[@type='number' and contains(@class,'input-response-time')]")
    private WebElement daysResponse;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@class,'requests')]")
    private WebElement personalisedVideoRequest;

    @FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Save Profile')]")
    private WebElement saveProfile;

    public ArtistDashboard(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseFile() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        //Replace path to the file on local machine
        StringSelection path = new StringSelection("D:\\OSR\\src\\main\\resources\\testImage.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void setNewProfileDetails() throws InterruptedException, AWTException {
        waitTillElementIsClickable(editProfilePicture, 5);
        clickOnElement(editProfilePicture, 5);
        chooseFile();
        clickOnElement(confirmProfilePicture);
        clickOnElement(editArtistPicture);
        chooseFile();
        clickOnElement(confirmArtistPicture);
        searchGenres.sendKeys("Rock");
        waitTillElementIsVisible(rockGenre);
        clickOnElement(rockGenre);
        artistBio.sendKeys("Test Bio");
        videoPrice.sendKeys("1500");
        daysResponse.sendKeys("5");
        personalisedVideoRequest.click();
        saveProfile.click();
        waitTillElementIsVisible(approvalText);
    }
}

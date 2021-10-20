package osr.net.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {

    public String superDuper = "SuperDuper";

    @FindBy(
            xpath =
                    "//app-home//app-bands-section//div[contains(text(),'MOST')]/parent::*//app-band-card//a[@class='band-name']")
    private WebElement firstMostPopularArtist;

    @FindBy(xpath = "//div[contains(@class,'search-box')]/input")
    private WebElement searchField;

    public Dashboard(WebDriver webDriver) {
        super(webDriver);
    }

    public void artistVideoRequest() {
        waitTillElementIsVisible(firstMostPopularArtist);
        clickOnElement(firstMostPopularArtist);
    }

    public String getArtistName() {
        return firstMostPopularArtist.getText();
    }

    public void searchForArtist() {
        waitTillElementIsVisible(searchField);
        searchField.sendKeys(superDuper);
        searchField.sendKeys(Keys.RETURN);
    }
}

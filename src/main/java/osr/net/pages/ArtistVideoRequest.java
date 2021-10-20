package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtistVideoRequest extends BasePage {

    @FindBy(xpath = "//app-bands-section//ngx-slick-carousel//app-band-card//a[@class='band-name']")
    protected WebElement artistName;

    @FindBy(xpath = "//div[contains(@class,'request-video')]/a")
    private WebElement request;

    public ArtistVideoRequest(WebDriver webDriver) {
        super(webDriver);
    }

    public void order() {
        clickOnElement(request, 5);
    }
}

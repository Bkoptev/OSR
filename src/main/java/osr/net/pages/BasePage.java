package osr.net.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import osr.net.base.SimpleAPI;

public class BasePage extends SimpleAPI {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }


}

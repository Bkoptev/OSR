package osr.net.base;

import com.google.common.base.Function;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SimpleAPI {

    public Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);;
    public static Actions actions;
    public static Robot robot;
    public abstract WebDriver getWebDriver();


    protected <V> V assertThat(Function<? super WebDriver, V> condition) {
        return (new WebDriverWait(getWebDriver(), 5)).until(condition);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition, int seconds) {
        return (new WebDriverWait(getWebDriver(), seconds)).until(condition);
    }

    protected WebElement waitTillElementIsVisible(WebElement element) {
        return assertThat(ExpectedConditions.visibilityOf(element));
    }

    protected Boolean waitTillElementIsNotVisible(String element) {
        return assertThat(
                ExpectedConditions.not(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(element))));
    }

    protected WebElement waitTillElementIsClickable(WebElement element, int seconds) {
        return assertThat(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickOnElement(WebElement element) {
        assertThat(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickOnElement(String element) {
        assertThat(ExpectedConditions.elementToBeClickable(By.xpath(element))).click();
    }

    protected void clickOnElement(WebElement element, int seconds) {
        assertThat(ExpectedConditions.elementToBeClickable(element), seconds).click();
    }

    protected Boolean verifyElementIsPresent(String xpath) {
        return assertThat(
                ExpectedConditions.not(
                        ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))));
    }

    protected String random4Digits() {
        return RandomStringUtils.random(4, false, true);
    }

    public void log(String message) {
        logger.info(message);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }

    public void error(String error) {
        logger.error(error);
    }

    public String getDateTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }
}

package osr.net.test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import osr.net.base.RunTestRules;
import osr.net.base.SimpleAPI;
import osr.net.pages.HomePage;
import osr.net.pages.LoginPage;
import osr.net.utils.YamlFile;
import osr.net.utils.YamlParser;

public class BaseTest extends SimpleAPI {
    public static WebDriver webDriver;
    public static YamlFile yamlFile;

    @Rule public RunTestRules runTestRules = new RunTestRules(this);

    @BeforeClass
    public static void setUp() throws IOException, AWTException {
        clearDirectories();

        ChromeOptions options = new ChromeOptions();
        /** Collection with settings of browser */
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        /** Options which are disable forgot password pop-up */
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        yamlFile = YamlParser.getYamlData();
        actions = new Actions(webDriver);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    protected HomePage openSite() {
        try {
            FileUtils.cleanDirectory(new File("src/main/resources/screenshots"));
            webDriver.get(YamlParser.getYamlData().getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HomePage(webDriver);
    }

    protected LoginPage openAdminSite() {
        try {
            FileUtils.cleanDirectory(new File("src/main/resources/screenshots"));
            webDriver.get(YamlParser.getYamlData().getAdminUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LoginPage(webDriver);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }


    protected static void clearDirectories() {

        try {
            FileUtils.cleanDirectory(new File("src/main/resources/screenshots"));
            FileUtils.cleanDirectory(new File("src/main/resources/logs"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

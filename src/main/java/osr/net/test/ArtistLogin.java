package osr.net.test;

import org.junit.Test;
import osr.net.pages.*;

public class ArtistLogin extends BaseTest {

    private String artistEmail = yamlFile.getArtistLogin();
    private String artistPassword = yamlFile.getArtistPassword();
    /** Open site and log in. Verify name. Log put and check the log in page. */
    @Test
    public void UserLoginTest() throws InterruptedException {

        openSite().goToLogInPage().logIn(artistEmail, artistPassword);
        log("User logged in to the application and dashboard loaded");
        ArtistDashboard artistDashboard = new ArtistDashboard(webDriver);
        Thread.sleep(3000);
    }
}

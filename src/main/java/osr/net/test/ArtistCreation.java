package osr.net.test;

import org.junit.Test;
import osr.net.pages.*;

import java.awt.*;

public class ArtistCreation extends BaseTest {
    @Test
    public void UserLoginTest() throws InterruptedException, AWTException {

        openSite().goToSignUpPage();
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.registerAsArtist();
        ArtistDashboard artistDashboard = new ArtistDashboard(webDriver);
        artistDashboard.setNewProfileDetails();
        Thread.sleep(2000);
    }
}

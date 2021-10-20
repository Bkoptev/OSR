package osr.net.test;

import org.junit.Test;
import osr.net.pages.SignUpPage;

public class UserCreation extends BaseTest {
    @Test
    public void UserLoginTest() throws InterruptedException {

        openSite().goToSignUpPage();
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.registerAsUser();
        Thread.sleep(3000);
    }
}

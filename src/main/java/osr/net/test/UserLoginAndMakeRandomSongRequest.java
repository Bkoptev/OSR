package osr.net.test;

import java.io.IOException;
import org.junit.Test;
import osr.net.pages.*;

public class UserLoginAndMakeRandomSongRequest extends BaseTest {
    private String userEmail = yamlFile.getUserLogin();
    private String userPassword = yamlFile.getUserPassword();

    @Test
    public void userLogin() throws InterruptedException, IOException {
        openSite().goToLogInPage().logIn(userEmail, userPassword);
        log("User logged in to the application and dashboard loaded");
        Dashboard dashboard = new Dashboard(webDriver);
        String artistName = dashboard.getArtistName();
        dashboard.artistVideoRequest();
        log("First most popular artist opened and artist name captured");
        ArtistVideoRequest artistVideoRequest = new ArtistVideoRequest(webDriver);
        artistVideoRequest.order();
        Order order = new Order(webDriver);
        order.completeRequestForm();
        CheckoutPage checkoutPage = order.checkoutPage();
        checkoutPage.cardFillOut();
        MyRequests myRequests = checkoutPage.myRequests();
        myRequests.closeRequestPage();
        myRequests.openRequests();
        myRequests.recentRequestCheck(artistName, order.usedNameInOrder);
        log("Info used while creating order match to created order completely");

        Thread.sleep(2000);
    }
}

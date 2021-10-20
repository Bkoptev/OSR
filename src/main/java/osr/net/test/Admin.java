/*
 *
 *
 * -------Run only after ArtistCreation test or in test suite
 * because of using randomly generated band name  for check!!!------
 *
 *
 * */

package osr.net.test;

import org.junit.Test;
import osr.net.pages.AdminDashboard;

public class Admin extends BaseTest {
    private String userEmail = yamlFile.getUserLogin();
    private String userPassword = yamlFile.getUserPassword();
    /** Open site and log in. Verify name. Log put and check the log in page. */
    @Test
    public void UserLoginTest() throws InterruptedException {
        openAdminSite().logIn(userEmail, userPassword);
        AdminDashboard adminDashboard = new AdminDashboard(webDriver);
        adminDashboard.checkBandChanges();
        Thread.sleep(3000);
    }
}

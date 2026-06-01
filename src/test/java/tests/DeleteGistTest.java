package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class DeleteGistTest extends BaseTest {

    @Test
    public void deleteExistingGistTest() {

        // ===== LOGIN =====
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                utils.EnvConfig.getUsername(),
                utils.EnvConfig.getPassword()
        );

        // ===== DASHBOARD =====
        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard belum muncul");

        dashboardPage.clickYourGists();

        UserGistPage userGistPage = new UserGistPage(driver);

        Assert.assertTrue(userGistPage.isGistListDisplayed(), "Tidak ada Gist untuk dihapus");

        userGistPage.openLatestGist();

        GistDetailPage gistDetailPage = new GistDetailPage(driver);


        String filename = "";
        try {
            filename = gistDetailPage.getFilename();
        } catch (Exception e) {

            filename = driver.getTitle().trim();
        }

        // DELETE GIST
        gistDetailPage.deleteGist();


        driver.navigate().refresh();

        boolean stillExists = driver.getPageSource().contains(filename);

        Assert.assertFalse(
                driver.getCurrentUrl().contains("/gist/"),
                "Gist was not deleted"
        );
    }
}
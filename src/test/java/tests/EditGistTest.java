package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.EnvConfig;

public class EditGistTest extends BaseTest {

    @Test
    public void editExistingGistTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                EnvConfig.getUsername(),
                EnvConfig.getPassword()
        );

        // Masuk ke daftar gist
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickYourGists();

        UserGistPage userGistPage = new UserGistPage(driver);
        Assert.assertTrue(
                userGistPage.isGistListDisplayed(),
                "Daftar Gist kosong"
        );

        // Gist yang diedit
        userGistPage.openGistByFilename("test-gist.txt");

        GistDetailPage gistDetailPage = new GistDetailPage(driver);
        gistDetailPage.clickEdit();

        GistEditPage gistEditPage = new GistEditPage(driver);

        String newDescription =
                "Spidey Update Deskripsi " + System.currentTimeMillis();

        gistEditPage.editDescription(newDescription);


        Assert.assertTrue(
                driver.getCurrentUrl().contains("/gist"),
                "Gagal update gist"
        );
    }
}
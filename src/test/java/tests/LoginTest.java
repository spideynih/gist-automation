package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.EnvConfig;

public class LoginTest extends BaseTest {

    @Test
    public void userCanLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                EnvConfig.getUsername(),
                EnvConfig.getPassword()
        );

        DashboardPage dashboard = new DashboardPage(driver);

        Assert.assertTrue(
                dashboard.isLoggedIn(),
                "Login gagal"
        );
    }
}
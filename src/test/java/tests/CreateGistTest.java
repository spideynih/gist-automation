package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateGistPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.EnvConfig;


public class CreateGistTest extends BaseTest {

    @Test
    public void userCanCreatePublicGist() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                EnvConfig.getUsername(),
                EnvConfig.getPassword()
        );


        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isLoggedIn(), "Login failed / dashboard not loaded");


        dashboard.clickCreateGist();


        CreateGistPage createGistPage = new CreateGistPage(driver);

        String description = "Automation Gist Test";
        String fileName = "test-gist.txt";
        String content = "console.log('Spidey Create Gist');";

        createGistPage.createPublicGist(description, fileName, content);

        Assert.assertTrue(driver.getCurrentUrl().contains("gist"), "Gist creation failed");
    }
}
package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        WaitUtils.waitForElementVisible(
                driver,
                org.openqa.selenium.By.xpath("//h6[text()='Dashboard']"),
                Integer.parseInt(ConfigReader.get("explicitWait"))
        );

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(),
                "Dashboard is not visible after login");
    }
}

package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.EmployeeListPage;
import pages.LoginPage;
import pages.MenuPage;
import utils.TestDataUtils;
import utils.WaitUtils;

import static org.openqa.selenium.By.xpath;

public class E2EEmployeeFlowTest extends BaseTest {

    @Test
    public void verifyAdminCanAddAndSearchEmployee_E2E() {

        // ---------- Test Data ----------
        String firstName = TestDataUtils.generateRandomName();
        String lastName = "User";

        // ---------- Login ----------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        WaitUtils.waitForElementVisible(
                driver,
                xpath("//h6[text()='Dashboard']"),
                Integer.parseInt(ConfigReader.get("explicitWait"))
        );

        // ---------- Navigate to PIM ----------
        MenuPage menuPage = new MenuPage(driver);
        menuPage.goToPIM();

        // ---------- Add Employee ----------
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.addEmployee(firstName, lastName);

        // ---------- Verify Personal Details Page ----------
        WaitUtils.waitForElementVisible(
                driver,
                xpath("//h6[text()='Personal Details']"),
                Integer.parseInt(ConfigReader.get("explicitWait"))
        );

        // ---------- Search Employee ----------
        menuPage.goToPIM();
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.searchEmployee(firstName);

        Assert.assertTrue(
                employeeListPage.isEmployeeDisplayed(),
                "Employee not found in employee list"
        );

        // ---------- Logout ----------
        menuPage.logout();
    }
}
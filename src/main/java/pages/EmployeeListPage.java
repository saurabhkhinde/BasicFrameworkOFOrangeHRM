package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage
{

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By employeeNameField =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By searchResult =
            By.xpath("//div[@class='oxd-table-card']");

    public void searchEmployee(String employeeName) {
        driver.findElement(employeeNameField).sendKeys(employeeName);
        driver.findElement(searchBtn).click();
    }

    public boolean isEmployeeDisplayed() {
        return driver.findElements(searchResult).size() > 0;
    }
}

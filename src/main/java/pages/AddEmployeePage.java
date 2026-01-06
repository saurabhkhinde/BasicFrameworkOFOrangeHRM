package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {

    private WebDriver driver;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By saveBtn = By.xpath("//button[@type='submit']");

    public void addEmployee(String fName, String lName) {
        driver.findElement(addEmployeeTab).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    private WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutBtn = By.xpath("//a[text()='Logout']");

    public void goToPIM() {
        driver.findElement(pimMenu).click();
    }

    public void logout() {
        driver.findElement(userDropdown).click();
        driver.findElement(logoutBtn).click();
    }
}

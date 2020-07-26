package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage (String url) {
        driver.get(url);
    }

    public HomePage login(String userName, String passwordKeys) {
        driver.findElement(By.cssSelector("#username")).sendKeys(userName);
        driver.findElement(By.cssSelector("#password")).sendKeys(passwordKeys);
        driver.findElement(By.cssSelector("#Login")).click();
        return new HomePage(driver);
    }
}

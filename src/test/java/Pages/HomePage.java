package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.Date;

public class HomePage extends BasePage {
    String contactTabUrl = "https://na111.lightning.force.com/lightning/o/Contact/list";
    Date currentDate = new Date();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openNewContactDialog() {
        driver.get(contactTabUrl);
        driver.findElement(By.cssSelector("a[title='New']")).click();
    }

    public void fillOutContactDialogAndSave() {
        driver.findElement(By.cssSelector("input[placeholder='Last Name']"))
                .sendKeys("Contact" + currentDate);
        driver.findElement(By.cssSelector("input[class^=lastName]")).click();
        driver.findElement(By.cssSelector("input[title='Search Accounts']")).click();
        driver.findElement(By.cssSelector("div[title='Test1']")).click();
        driver.findElement(By.cssSelector("button[title='Save']")).click();
    }
}

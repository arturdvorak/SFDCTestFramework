package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Date;

public class NewContactModal extends BasePage {
    Date currentDate = new Date();
    By buttonNew = By.cssSelector("a[title='New']");
    By lastNameInput = By.cssSelector("input[placeholder='Last Name']");
    By fieldSearchAccount = By.cssSelector("input[title='Search Accounts']");
    By firstItem = By.cssSelector("div[title='Test1");
    By buttonSave = By.cssSelector("button[title='Save']");


    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.findElement(buttonNew).click();
    }

    public void fillOutContactDialogAndSave(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName + currentDate);
        driver.findElement(fieldSearchAccount).click();
        driver.findElement(firstItem).click();
    }

    public void saveNewContact() {
        driver.findElement(buttonSave).click();
    }
}

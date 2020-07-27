package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Date;

public class NewContactModal extends BasePage {
    private static final By lastNameInput = By.cssSelector("input[placeholder='Last Name']");
    private static final By fieldSearchAccount = By.cssSelector("input[title='Search Accounts']");
    private static final By firstItem = By.cssSelector("div[title='Test1");
    private static final By buttonSave = By.cssSelector("button[title='Save']");
    Date currentDate = new Date();


    public NewContactModal(WebDriver driver) {
        super(driver);
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

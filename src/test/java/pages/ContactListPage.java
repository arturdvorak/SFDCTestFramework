package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage {
    private static final By buttonNew = By.cssSelector("a[title='New']");
    private static final String contactTabUrl = "https://na111.lightning.force.com/lightning/o/Contact/list";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(contactTabUrl);
    }

    public void openNewContactModal() {
        driver.findElement(buttonNew).click();
    }
}

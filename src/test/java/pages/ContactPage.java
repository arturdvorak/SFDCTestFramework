package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {
    private static final By BUTTON_DELETE = By.cssSelector("div[title='Delete']");
    private static final By BUTTON_DELETE_IN_MODAL = By.cssSelector("button[title='Delete']");
    private static final By TITLE_CONTACTS = By.xpath("//li/span[text()='Contacts']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void deleteOpenedContact(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE));
        driver.findElement(BUTTON_DELETE).click();
        driver.switchTo().activeElement();
        driver.findElement(BUTTON_DELETE_IN_MODAL).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACTS));
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {
    private static final By buttonDelete = By.cssSelector("div[title='Delete']");
    private static final By buttonDeleteInModal = By.cssSelector("button[title='Delete']");
    private static final By contactsBanner = By.cssSelector("img[title='Contacts']");
    private static final By contactsTitle = By.xpath("//li/span[text()='Contacts']");


    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void deleteOpenedContact(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDelete));
        driver.findElement(buttonDelete).click();
        driver.switchTo().activeElement();
        driver.findElement(buttonDeleteInModal).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactsTitle));
    }
}

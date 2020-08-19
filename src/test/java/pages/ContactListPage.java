package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactListPage extends BasePage {
    private static final String contactTabUrl = "https://na111.lightning.force.com/lightning/o/Contact/list";
    private static final By buttonNew = By.cssSelector("a[title='New']");
    private static final By contactBanner = By.cssSelector("img[title='Contact']");
    private static final By newContactModalFrame = By.cssSelector("div[class='isModal inlinePanel oneRecordActionWrapper']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(contactTabUrl);
    }

    public void openNewContactModal() {
        driver.findElement(buttonNew).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(newContactModalFrame)));
    }

    public String getContactLink(Contact contact) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']",
                contact.getFirstName() + " "
                        + contact.getMiddleName() + " "
                        + contact.getLastName() + " "
                        + contact.getSuffix())))
                .getAttribute("href");
    }

    public void openContact(Contact contact) {
        driver.get(getContactLink(contact));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(contactBanner));
    }
}

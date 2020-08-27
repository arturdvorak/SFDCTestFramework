package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactListPage extends BasePage {
    private final String URL_CONTACT_TAB = base_url + "o/Contact/list";
    private static final By BUTTON_NEW = By.cssSelector("a[title='New']");
    private static final By TITLE_CONTACT_IN_PANEL = By.xpath("//h1/div[text()='Contact']");
    private static final By TITLE_NEW_CONTACT_IN_MODAL = By.xpath("//h2[text()='New Contact']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL_CONTACT_TAB);
    }

    public void openNewContactModal() {
        driver.findElement(BUTTON_NEW).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE_NEW_CONTACT_IN_MODAL)));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACT_IN_PANEL));
    }
}

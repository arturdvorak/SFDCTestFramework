package pages;

import elements.Button;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class ContactListPage extends BasePage {
    private static final String URL_CONTACT_TAB = BaseTest.base_url + "o/Contact/list";
    private static final By TITLE_CONTACT_IN_PANEL = By.xpath("//h1/div[text()='Contact']");
    private static final By TITLE_NEW_CONTACT_IN_MODAL = By.xpath("//h2[text()='New Contact']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage() {
        driver.get(URL_CONTACT_TAB);
        return this;
    }

    public NewContactModal openNewContactModal() {
        new Button(driver, "New").click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE_NEW_CONTACT_IN_MODAL)));
        return new NewContactModal(driver);
    }

    public String getContactLink(Contact contact) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']",
                contact.getFirstName() + " " + contact.getLastName()))).getAttribute("href");
    }

    public ContactViewPage openContact(Contact contact) {
        driver.get(getContactLink(contact));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACT_IN_PANEL));
        return new ContactViewPage(driver);
    }
}

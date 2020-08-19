package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactListPage extends BasePage {
    private static final String UTL_CONTACT_TAB = "https://na111.lightning.force.com/lightning/o/Contact/list";
    private static final By BUTTON_NEW = By.cssSelector("a[title='New']");
    private static final By BANNER_CONTACT = By.cssSelector("img[title='Contact']");
    private static final By TITLE_CONTACT = By.xpath("//h1/div[text()='Contact']");
    private static final By FRAME_NEW_CONTACT_MODAL = By.cssSelector("div[class='isModal inlinePanel oneRecordActionWrapper']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(UTL_CONTACT_TAB);
    }

    public void openNewContactModal() {
        driver.findElement(BUTTON_NEW).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(FRAME_NEW_CONTACT_MODAL)));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACT));
    }
}

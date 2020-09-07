package pages;

import elements.*;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class ContactViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath("//a[@data-label='Details' and @tabindex='-1']");
    private static final By FIELD_NAME_EDIT = By.xpath("//div/span[text()='Name']/../..//button");
    private static final By FIELD_NAME = By.xpath("//div/span[text()='Name']/../../div[2]/span/slot/slot/lightning-formatted-name");
    private static final By FIELD_TITLE = By.xpath("//span[text()='Title']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By FIELD_DEPARTMENT = By.xpath("//span[text()='Department']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By FIELD_ADDRESS_STREET = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[1]");
    private static final By FIELD_ADDRESS_CITY_STATE_ZIP = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[2]");
    private static final By FIELD_ADDRESS_COUNTRY = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[3]");
    private static final By BUTTON_SAVE = By.xpath("//button[@title='Save']");

    public ContactViewPage(WebDriver driver) {
        super(driver);
    }

    public void updateOpenContact(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_NAME_EDIT).click();

        new LightningDropDown(driver, "Salutation").select(contact.getSalutation());

        new LightningInput(driver, "First Name").fillInput(contact.getFirstName());
        new LightningInput(driver, "Middle Name").fillInput(contact.getMiddleName());
        new LightningInput(driver, "Last Name").fillInput(contact.getLastName());
        new LightningInput(driver, "Suffix").fillInput(contact.getSuffix());

        new LightningLookUp(driver, "Account Name").select(contact.getAccountName());
        new LightningLookUp(driver, "Reports To").select(contact.getReportsTo());

        new LightningInput(driver, "Title").fillInput(contact.getTitle());
        new LightningInput(driver, "Email").fillInput(contact.getEmail());
        new LightningInput(driver, "Phone").fillInput(contact.getPhone());
        new LightningInput(driver, "Mobile").fillInput(contact.getMobile());
        new LightningInput(driver, "Department").fillInput(contact.getDepartment());
        new LightningInput(driver, "Fax").fillInput(contact.getFax());
        new TextArea(driver, "Mailing Street").fillInput(contact.getMailingStreet());
        new LightningInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new LightningInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new LightningInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new LightningInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());

        driver.findElement(BUTTON_SAVE).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_NAME_EDIT));
    }

    public void validateContactData(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        assertEquals(driver.findElement(FIELD_NAME).getText(),
                contact.getSalutation() + " "
                        + contact.getFirstName() + " "
                        + contact.getMiddleName() + " "
                        + contact.getLastName() + " "
                        + contact.getSuffix(),
                "Name is saved incorrectly.");

        new ForceRecord(driver, "Account Name").validateFieldValue(contact.getAccountName());
        new ForceRecord(driver, "Email").validateFieldValue(contact.getEmail());
        new ForceRecord(driver, "Phone").validateFieldValue(contact.getPhone());
        new ForceRecord(driver, "Mobile").validateFieldValue(contact.getMobile());
        new ForceRecord(driver, "Reports To").validateFieldValue(contact.getReportsTo());
        new ForceRecord(driver, "Fax").validateFieldValue(contact.getFax());

        assertEquals(driver.findElement(FIELD_TITLE).getText(), contact.getTitle(),
                "Title is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_DEPARTMENT).getText(), contact.getDepartment(),
                "Department is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_ADDRESS_STREET).getText(), contact.getMailingStreet(),
                "MailingStreet is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_ADDRESS_CITY_STATE_ZIP).getText(),
                contact.getMailingCity() + ", "
                        + contact.getMailingState() + " "
                        + contact.getMailingZip(),
                "CityStateZip is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_ADDRESS_COUNTRY).getText(), contact.getMailingCountry(),
                "MailingCountry is saved incorrectly.");
    }

    public void closeContact() {
    }
}

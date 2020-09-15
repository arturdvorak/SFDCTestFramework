package pages;

import elements.*;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath(ACTIVE_TAB_LOCATOR + "//a[@data-label='Details']");
    private static final By FIELD_NAME_EDIT = By.xpath("//div/span[text()='Name']/../..//button");
    private static final By TITLE_CONTACTS = By.xpath("//li/span[text()='Contacts']");

    public ContactViewPage(WebDriver driver) {
        super(driver);
    }

    public void updateOpenContact(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_NAME_EDIT).click();
        waitForPageLoaded();
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
        new Button(driver, "Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_NAME_EDIT));
    }

    public void validateContactData(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        waitForPageLoaded();
        new ForceRecord(driver, "Name").validateFieldValue(contact.getSalutation() + " "
                + contact.getFirstName() + " "
                + contact.getMiddleName() + " "
                + contact.getLastName() + " "
                + contact.getSuffix());
        new ForceRecord(driver, "Account Name").validateFieldValue(contact.getAccountName());
        new ForceRecord(driver, "Title").validateFieldValue(contact.getTitle());
        new ForceRecord(driver, "Email").validateFieldValue(contact.getEmail());
        new ForceRecord(driver, "Phone").validateFieldValue(contact.getPhone());
        new ForceRecord(driver, "Mobile").validateFieldValue(contact.getMobile());
        new ForceRecord(driver, "Reports To").validateFieldValue(contact.getReportsTo());
        new ForceRecord(driver, "Department").validateFieldValue(contact.getDepartment());
        new ForceRecord(driver, "Fax").validateFieldValue(contact.getFax());
        new ForceRecord(driver, "Mailing Address").validateFieldValue(
                contact.getMailingStreet() + "\n"
                        + contact.getMailingCity() + ", "
                        + contact.getMailingState() + " "
                        + contact.getMailingZip() + "\n"
                        + contact.getMailingCountry());
    }

    public void deleteOpenedContact(){
        new Button(driver,"Delete").click();
        driver.switchTo().activeElement();
        new Button(driver,"Delete").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACTS));
    }
}

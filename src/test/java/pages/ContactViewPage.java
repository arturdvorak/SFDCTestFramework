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

    public ContactListPage updateOpenContact(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_NAME_EDIT).click();
        waitForPageLoaded();
        new LightningDropDown(driver, "Salutation").select(contact.getSalutation());
        new LightningInput(driver, "First Name").fillInput(contact.getFirstName());
        new LightningInput(driver, "Last Name").fillInput(contact.getLastName());
        new LightningLookUp(driver, "Account Name").select(contact.getAccountName());
        new LightningInput(driver, "Title").fillInput(contact.getTitle());
        new LightningInput(driver, "Department").fillInput(contact.getDepartment());
        new LightningInput(driver, "Birthdate").fillInput(contact.getBirthdate());
        new LightningLookUp(driver, "Reports To").select(contact.getReportsTo());
        new LightningDropDown(driver, "Lead Source").select(contact.getLeadSorurce());
        new LightningInput(driver, "Phone").fillInput(contact.getPhone());
        new LightningInput(driver, "Home Phone").fillInput(contact.getHomePhone());
        new LightningInput(driver, "Mobile").fillInput(contact.getMobile());
        new LightningInput(driver, "Other Phone").fillInput(contact.getOtherPhone());
        new LightningInput(driver, "Fax").fillInput(contact.getFax());
        new LightningInput(driver, "Email").fillInput(contact.getEmail());
        new LightningInput(driver, "Assistant").fillInput(contact.getAssistant());
        new LightningInput(driver, "Asst. Phone").fillInput(contact.getAssistantPhone());
        new TextArea(driver, "Mailing Street").fillInput(contact.getMailingStreet());
        new LightningInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new LightningInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new LightningInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new LightningInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());
        new TextArea(driver, "Other Street").fillInput(contact.getOtherStreet());
        new LightningInput(driver, "Other City").fillInput(contact.getOtherCity());
        new LightningInput(driver, "Other State/Province").fillInput(contact.getOtherState());
        new LightningInput(driver, "Other Zip/Postal Code").fillInput(contact.getOtherZip());
        new LightningInput(driver, "Other Country").fillInput(contact.getOtherCountry());
        new LightningInput(driver, "Languages").fillInput(contact.getLang());
        new LightningDropDown(driver, "Level").select(contact.getLevel());
        new TextArea(driver, "Description").fillInput(contact.getDescription());
        new Button(driver, "Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_NAME_EDIT));
        return new ContactListPage(driver);
    }

    public ContactListPage validateContactData(Contact contact) {
        driver.findElement(TAB_DETAILS).click();
        waitForPageLoaded();
        new ForceRecord(driver, "Name").validateFieldValue(contact.getSalutation() + " "
                + contact.getFirstName() + " "
                + contact.getLastName());
        new ForceRecord(driver, "Account Name").validateFieldValue(contact.getAccountName());
        new ForceRecord(driver, "Title").validateFieldValue(contact.getTitle());
        new ForceRecord(driver, "Department").validateFieldValue(contact.getDepartment());
        new ForceRecord(driver, "Birthdate").validateFieldValue(contact.getBirthdate());
        new ForceRecord(driver, "Reports To").validateFieldValue(contact.getReportsTo());
        new ForceRecord(driver, "Lead Source").validateFieldValue(contact.getLeadSorurce());
        new ForceRecord(driver, "Phone").validateFieldValue(contact.getPhone());
        new ForceRecord(driver, "Home Phone").validateFieldValue(contact.getHomePhone());
        new ForceRecord(driver, "Mobile").validateFieldValue(contact.getMobile());
        new ForceRecord(driver, "Other Phone").validateFieldValue(contact.getOtherPhone());
        new ForceRecord(driver, "Fax").validateFieldValue(contact.getFax());
        new ForceRecord(driver, "Email").validateFieldValue(contact.getEmail());
        new ForceRecord(driver, "Assistant").validateFieldValue(contact.getAssistant());
        new ForceRecord(driver, "Asst. Phone").validateFieldValue(contact.getAssistantPhone());
        new ForceRecord(driver, "Mailing Address").validateFieldValue(
                contact.getMailingStreet() + "\n"
                        + contact.getMailingCity() + ", "
                        + contact.getMailingState() + " "
                        + contact.getMailingZip() + "\n"
                        + contact.getMailingCountry());
        new ForceRecord(driver, "Other Address").validateFieldValue(
                contact.getOtherStreet() + "\n"
                        + contact.getOtherCity() + ", "
                        + contact.getOtherState() + " "
                        + contact.getOtherZip() + "\n"
                        + contact.getOtherCountry());
        new ForceRecord(driver, "Languages").validateFieldValue(contact.getLang());
        new ForceRecord(driver, "Level").validateFieldValue(contact.getLevel());
        new ForceRecord(driver, "Description").validateFieldValue(contact.getDescription());
        return new ContactListPage(driver);
    }

    public ContactViewPage deleteOpenedContact(){
        new Button(driver,"Show 5 more actions").click();
        new Button(driver,"Delete").clickUsingJavaScript();
        driver.switchTo().activeElement();
        new Button(driver,"Delete").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CONTACTS));
        return new ContactViewPage(driver);
    }
}

package pages;

import elements.*;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModal extends BasePage {
    private static final By BANNER_CONTACT = By.cssSelector("img[title='Contact']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillOutNewContactModal(Contact contact) {
        waitForPageLoaded();
        new SFDropDown(driver, "Salutation").select(contact.getSalutation());
        new SFInput(driver, "First Name").fillInput(contact.getFirstName());
        new SFInput(driver, "Last Name").fillInput(contact.getLastName());
        new SFLookUp(driver, "Account Name").select(contact.getAccountName());
        new SFInput(driver, "Title").fillInput(contact.getTitle());
        new SFInput(driver, "Department").fillInput(contact.getDepartment());
        new SFInput(driver, "Birthdate").fillInput(contact.getBirthdate());
        new SFLookUp(driver, "Reports To").select(contact.getReportsTo());
        new SFDropDown(driver, "Lead Source").select(contact.getLeadSorurce());
        new SFInput(driver, "Phone").fillInput(contact.getPhone());
        new SFInput(driver, "Home Phone").fillInput(contact.getHomePhone());
        new SFInput(driver, "Mobile").fillInput(contact.getMobile());
        new SFInput(driver, "Other Phone").fillInput(contact.getOtherPhone());
        new SFInput(driver, "Fax").fillInput(contact.getFax());
        new SFInput(driver, "Email").fillInput(contact.getEmail());
        new SFInput(driver, "Assistant").fillInput(contact.getAssistant());
        new SFInput(driver, "Asst. Phone").fillInput(contact.getAssistantPhone());

        new TextArea(driver, "Mailing Street").fillInput(contact.getMailingStreet());
        new SFInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new SFInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new SFInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new SFInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());
        new TextArea(driver, "Other Street").fillInput(contact.getOtherStreet());
        new SFInput(driver, "Other City").fillInput(contact.getOtherCity());
        new SFInput(driver, "Other State/Province").fillInput(contact.getOtherState());
        new SFInput(driver, "Other Zip/Postal Code").fillInput(contact.getOtherZip());
        new SFInput(driver, "Other Country").fillInput(contact.getOtherCountry());

        new SFInput(driver, "Languages").fillInput(contact.getLang());
        new SFDropDown(driver, "Level").select(contact.getLevel());
        new TextArea(driver, "Description").fillInput(contact.getDescription());
    }

    public void saveContact() {
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_CONTACT));
    }
}

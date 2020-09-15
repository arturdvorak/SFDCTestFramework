package pages;

import elements.*;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModal extends BasePage {
    private static final By BANNER_CONTACT = By.cssSelector("img[title='Contact']");
    private static final By BUTTON_SAVE = By.cssSelector("button[title='Save']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillOutNewContactModal(Contact contact) {
        waitForPageLoaded();
        new SFDropDown(driver, "Salutation").select(contact.getSalutation());
        new SFInput(driver, "First Name").fillInput(contact.getFirstName());
        new SFInput(driver, "Middle Name").fillInput(contact.getMiddleName());
        new SFInput(driver, "Last Name").fillInput(contact.getLastName());
        new SFInput(driver, "Suffix").fillInput(contact.getSuffix());
        new SFLookUp(driver, "Account Name").select(contact.getAccountName());
        new SFLookUp(driver, "Reports To").select(contact.getReportsTo());
        new SFInput(driver, "Title").fillInput(contact.getTitle());
        new SFInput(driver, "Email").fillInput(contact.getEmail());
        new SFInput(driver, "Phone").fillInput(contact.getPhone());
        new SFInput(driver, "Mobile").fillInput(contact.getMobile());
        new SFInput(driver, "Department").fillInput(contact.getDepartment());
        new SFInput(driver, "Fax").fillInput(contact.getFax());
        new TextArea(driver, "Mailing Street").fillInput(contact.getMailingStreet());
        new SFInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new SFInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new SFInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new SFInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());
    }

    public void saveContact() {
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_CONTACT));
    }
}

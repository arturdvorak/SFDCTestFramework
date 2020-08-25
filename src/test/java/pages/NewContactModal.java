package pages;

import elements.DropDown;
import elements.DropDownWithSearch;
import elements.TextArea;
import elements.TextInput;
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
        new DropDown(driver, "Salutation").fillInput(contact.getSalutation());
        new TextInput(driver, "First Name").fillInput(contact.getFirstName());
        new TextInput(driver, "Middle Name").fillInput(contact.getMiddleName());
        new TextInput(driver, "Last Name").fillInput(contact.getLastName());
        new TextInput(driver, "Suffix").fillInput(contact.getSuffix());

        new DropDownWithSearch(driver, "Account Name").fillInput(contact.getAccountName());
        new DropDownWithSearch(driver, "Reports To").fillInput(contact.getReportsTo());

        new TextInput(driver, "Title").fillInput(contact.getTitle());
        new TextInput(driver, "Email").fillInput(contact.getEmail());
        new TextInput(driver, "Phone").fillInput(contact.getPhone());
        new TextInput(driver, "Mobile").fillInput(contact.getMobile());
        new TextInput(driver, "Department").fillInput(contact.getDepartment());
        new TextInput(driver, "Fax").fillInput(contact.getFax());
        new TextArea(driver, "Mailing Street").fillInput(contact.getMailingStreet());
        new TextInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new TextInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new TextInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new TextInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());
    }

    public void saveContact() {
        driver.findElement(BUTTON_SAVE).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_CONTACT));
    }
}

package pages;

import elements.TextArea;
import elements.TextFieldAsLink;
import elements.TextInput;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class ContactViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath("//a[@data-label='Details' and @tabindex='-1']");
    private static final By FIELD_NAME_EDIT = By.xpath("//div/span[text()='Name']/../..//button");

    private static final By DROPDOWN_SALUTATION = By.xpath("//input[@name='salutation']");

    private static final By BUTTON_CLEAR_ACCOUNT_NAME = By.xpath("//label[text()='Account Name']/../div//button/lightning-primitive-icon");
    private static final By INPUT_SEARCH_ACCOUNT = By.xpath("//input[@placeholder='Search Accounts...']");

    private static final By BUTTON_CLEAR_REPORTS_TO = By.xpath("//label[text()='Reports To']/../div//button/lightning-primitive-icon");
    private static final By INPUT_REPORTS_TO = By.xpath("//input[@placeholder='Search Contacts...']");

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
        driver.findElement(DROPDOWN_SALUTATION).click();

        //the following action is failed sometime, in 10% of cases
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getSalutation()))).click();

        new TextInput(driver, "First Name").fillInput(contact.getFirstName());
        new TextInput(driver, "Middle Name").fillInput(contact.getMiddleName());
        new TextInput(driver, "Last Name").fillInput(contact.getLastName());
        new TextInput(driver, "Suffix").fillInput(contact.getSuffix());

        driver.findElement(BUTTON_CLEAR_ACCOUNT_NAME).click();
        driver.findElement(INPUT_SEARCH_ACCOUNT).click();
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getAccountName()))).click();
        driver.findElement(BUTTON_CLEAR_REPORTS_TO).click();
        driver.findElement(INPUT_REPORTS_TO).click();
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getReportsTo()))).click();

        new TextInput(driver, "Title").fillInput(contact.getTitle());
        new TextInput(driver, "Email").fillInput(contact.getEmail());
        new TextInput(driver, "Phone").fillInput(contact.getPhone());
        new TextInput(driver, "Mobile").fillInput(contact.getMobile());
        new TextInput(driver, "Department").fillInput(contact.getDepartment());
        new TextInput(driver, "Fax").fillInput(contact.getFax());
        new TextArea(driver, "Mailing Street").fillTextArea(contact.getMailingStreet());
        new TextInput(driver, "Mailing City").fillInput(contact.getMailingCity());
        new TextInput(driver, "Mailing State/Province").fillInput(contact.getMailingState());
        new TextInput(driver, "Mailing Zip/Postal Code").fillInput(contact.getMailingZip());
        new TextInput(driver, "Mailing Country").fillInput(contact.getMailingCountry());

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

        new TextFieldAsLink(driver, "Account Name").validateFieldValue(contact.getAccountName());
        new TextFieldAsLink(driver, "Email").validateFieldValue(contact.getEmail());
        new TextFieldAsLink(driver, "Phone").validateFieldValue(contact.getPhone());
        new TextFieldAsLink(driver, "Mobile").validateFieldValue(contact.getMobile());
        new TextFieldAsLink(driver, "Reports To").validateFieldValue(contact.getReportsTo());
        new TextFieldAsLink(driver, "Fax").validateFieldValue(contact.getFax());

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

package pages;

import elements.TextArea;
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
    private static final By FIELD_ACCOUNT_NAME = By.xpath("//span[text()='Account Name']/../../div[2]//a");
    private static final By FIELD_TITLE = By.xpath("//span[text()='Title']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By FIELD_EMAIL = By.xpath("//span[text()='Email']/../../div[2]//a");
    private static final By FIELD_PHONE = By.xpath("//span[text()='Phone']/../../div[2]//a");
    private static final By FIELD_MOBILE = By.xpath("//span[text()='Mobile']/../../div[2]//a");
    private static final By FIELD_REPORT_TO = By.xpath("//span[text()='Reports To']/../../div[2]//a");
    private static final By FIELD_DEPARTMENT = By.xpath("//span[text()='Department']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By FIELD_FAX = By.xpath("//span[text()='Fax']/../../div[2]//a");
    private static final By FIELD_ADDRESS_STREET = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[1]");
    private static final By FIELD_ADDRESS_CITY_STATE_ZIP = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[2]");
    private static final By FIELD_ADDRESS_COUNTRY = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[3]");
    private static final By BUTTON_SAVE = By.xpath("//button[@title='Save']");

    public ContactViewPage(WebDriver driver) {
        super(driver);
    }

    public void updateOpenContact(Contact contact) {
        driver.get("https://ap16.lightning.force.com/lightning/r/Contact/0032w00000I4v9iAAB/view");
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_NAME_EDIT).click();
        driver.findElement(DROPDOWN_SALUTATION).click();

        //the following action is failed sometime, in 10% of cases
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getSalutation()))).click();

        new TextInput(driver, "First Name", contact.getFirstName()).fillInput();
        new TextInput(driver, "Middle Name", contact.getMiddleName()).fillInput();
        new TextInput(driver, "Last Name", contact.getLastName()).fillInput();
        new TextInput(driver, "Suffix", contact.getSuffix()).fillInput();

        driver.findElement(BUTTON_CLEAR_ACCOUNT_NAME).click();
        driver.findElement(INPUT_SEARCH_ACCOUNT).click();
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getAccountName()))).click();
        driver.findElement(BUTTON_CLEAR_REPORTS_TO).click();
        driver.findElement(INPUT_REPORTS_TO).click();
        driver.findElement(By.xpath(String.format("//span[@title='%s']", contact.getReportsTo()))).click();

        new TextInput(driver, "Title", contact.getTitle()).fillInput();
        new TextInput(driver, "Email", contact.getEmail()).fillInput();
        new TextInput(driver, "Phone", contact.getPhone()).fillInput();
        new TextInput(driver, "Mobile", contact.getMobile()).fillInput();
        new TextInput(driver, "Department", contact.getDepartment()).fillInput();
        new TextInput(driver, "Fax", contact.getFax()).fillInput();
        new TextArea(driver, "Mailing Street", contact.getMailingStreet()).fillTextArea();
        new TextInput(driver, "Mailing City", contact.getMailingCity()).fillInput();
        new TextInput(driver, "Mailing State/Province", contact.getMailingState()).fillInput();
        new TextInput(driver, "Mailing Zip/Postal Code", contact.getMailingZip()).fillInput();
        new TextInput(driver, "Mailing Country", contact.getMailingCountry()).fillInput();

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
        assertEquals(driver.findElement(FIELD_ACCOUNT_NAME).getText(), contact.getAccountName(),
                "Account Name is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_TITLE).getText(), contact.getTitle(),
                "Title is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_EMAIL).getText(), contact.getEmail(),
                "Email is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_PHONE).getText(), contact.getPhone(),
                "Phone is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_MOBILE).getText(), contact.getMobile(),
                "Mobile is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_REPORT_TO).getText(), contact.getReportsTo(),
                "Reports To is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_DEPARTMENT).getText(), contact.getDepartment(),
                "Department is saved incorrectly.");
        assertEquals(driver.findElement(FIELD_FAX).getText(), contact.getFax(),
                "Fax is saved incorrectly.");
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

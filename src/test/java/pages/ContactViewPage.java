package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ContactViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath("//a[@data-label='Details' and @tabindex='-1']");
    private static final By FIELD_NAME_EDIT = By.xpath("//div/span[text()='Name']/../..//button");

    //By.cssSelector doesn't work -> changing to By.xpath
    private static final By DROPDOWN_SALUTATION = By.xpath("//input[@name='salutation']");
    private static final By INPUT_FIRST_NAME = By.xpath("//input[@placeholder='First Name']");
    private static final By INPUT_MIDDLE_NAME = By.xpath("//input[@placeholder='Middle Name']");
    private static final By INPUT_LAST_NAME = By.xpath("//input[@placeholder='Last Name']");
    private static final By INPUT_SUFFIX = By.xpath("//input[@placeholder='Suffix']");

    private static final By BUTTON_CLEAR_ACCOUNT_NAME = By.xpath("//label[text()='Account Name']/../div//button");
    private static final By INPUT_SEARCH_ACCOUNT = By.xpath("//input[@placeholder='Search Accounts...']");

    private static final By BUTTON_CLEAR_REPORTS_TO = By.xpath("//label[text()='Reports To']/../div//button");
    private static final By INPUT_REPORTS_TO = By.xpath("//input[@placeholder='Search Contacts...']");

    private static final By INPUT_TITLE = By.xpath("//input[@name='Title']");
    private static final By INPUT_EMAIL = By.xpath("//input[@name='Email']");
    private static final By INPUT_PHONE = By.xpath("//input[@name='Phone']");
    private static final By INPUT_MOBILE = By.xpath("//input[@name='MobilePhone']");
    private static final By INPUT_DEPARTMENT = By.xpath("//input[@name='Department']");
    private static final By INPUT_FAX = By.xpath("//input[@name='Fax']");
    private static final By INPUT_STREET = By.xpath("//textarea[@name='street']");
    private static final By INPUT_CITY = By.xpath("//input[@name='city']");
    private static final By INPUT_STATE = By.xpath("//input[@name='province']");
    private static final By INPUT_ZIP = By.xpath("//input[@name='postalCode']");
    private static final By INPUT_COUNTRY = By.xpath("//input[@name='country']");

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

    public ContactViewPage(WebDriver driver) {
        super(driver);
    }

    public void updateOpenContact(Contact contact) {
        driver.get("https://ap16.lightning.force.com/lightning/r/Contact/0032w00000I4v9iAAB/view");
        driver.findElement(TAB_DETAILS).click();
        driver.findElement(FIELD_NAME_EDIT).click();

        driver.findElement(DROPDOWN_SALUTATION).click();
        driver.findElement(By.xpath(String.format("//span[text()='%s']", contact.getSalutation()))).click();
        driver.findElement(INPUT_FIRST_NAME).clear();
        driver.findElement(INPUT_FIRST_NAME).sendKeys(contact.getFirstName());
        driver.findElement(INPUT_MIDDLE_NAME).clear();
        driver.findElement(INPUT_MIDDLE_NAME).sendKeys(contact.getMiddleName());
        driver.findElement(INPUT_LAST_NAME).clear();
        driver.findElement(INPUT_LAST_NAME).sendKeys(contact.getLastName());
        driver.findElement(INPUT_SUFFIX).clear();
        driver.findElement(INPUT_SUFFIX).sendKeys(contact.getSuffix());

        driver.findElement(BUTTON_CLEAR_ACCOUNT_NAME).click();
        driver.findElement(By.cssSelector(String.format("span[title='%s']", contact.getAccountName()))).click();
        driver.findElement(INPUT_SEARCH_ACCOUNT).sendKeys(contact.getAccountName());
        driver.findElement(By.cssSelector(String.format("span[title='%s']", contact.getReportsTo()))).click();

        driver.findElement(BUTTON_CLEAR_REPORTS_TO).click();
        driver.findElement(INPUT_REPORTS_TO).sendKeys(contact.getReportsTo());

        driver.findElement(INPUT_TITLE).clear();
        driver.findElement(INPUT_TITLE).sendKeys(contact.getTitle());
        driver.findElement(INPUT_EMAIL).clear();
        driver.findElement(INPUT_EMAIL).sendKeys(contact.getEmail());
        driver.findElement(INPUT_PHONE).clear();
        driver.findElement(INPUT_PHONE).sendKeys(contact.getPhone());
        driver.findElement(INPUT_MOBILE).clear();
        driver.findElement(INPUT_MOBILE).sendKeys(contact.getMobile());
        driver.findElement(INPUT_DEPARTMENT).clear();
        driver.findElement(INPUT_DEPARTMENT).sendKeys(contact.getDepartment());
        driver.findElement(INPUT_FAX).clear();
        driver.findElement(INPUT_FAX).sendKeys(contact.getFax());

        driver.findElement(INPUT_STREET).clear();
        driver.findElement(INPUT_STREET).sendKeys(contact.getMailingStreet());
        driver.findElement(INPUT_CITY).clear();
        driver.findElement(INPUT_CITY).sendKeys(contact.getMailingCity());
        driver.findElement(INPUT_STATE).clear();
        driver.findElement(INPUT_STATE).sendKeys(contact.getMailingState());
        driver.findElement(INPUT_ZIP).clear();
        driver.findElement(INPUT_ZIP).sendKeys(contact.getMailingZip());
        driver.findElement(INPUT_COUNTRY).clear();
        driver.findElement(INPUT_COUNTRY).sendKeys(contact.getMailingCountry());

        driver.findElement(By.xpath("Test"));

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

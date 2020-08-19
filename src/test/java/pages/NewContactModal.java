package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModal extends BasePage {
    private static final By BANNER_CONTACT = By.cssSelector("img[title='Contact']");

    private static final By DROPDOWN_SALUTATION = By.cssSelector("div[class='uiPopupTrigger']");
    private static final By INPUT_FIRST_NAME = By.cssSelector("input[placeholder='First Name']");
    private static final By INPUT_MIDDLE_NAME = By.cssSelector("input[placeholder='Middle Name']");
    private static final By INPUT_LAST_NAME = By.cssSelector("input[placeholder='Last Name']");
    private static final By INPUT_SUFFIX = By.cssSelector("input[placeholder='Suffix']");

    private static final By FIELD_SEARCH_ACCOUNT = By.cssSelector("input[title='Search Accounts']");

    private static final By INPUT_TITLE = By.xpath("//span[text() = 'Title']/../../input");
    private static final By INPUT_EMAIL = By.xpath("//span[text() = 'Email']/../../input");
    private static final By INPUT_PHONE = By.xpath("//span[text() = 'Phone']/../../input");
    private static final By INPUT_MOBILE = By.xpath("//span[text() = 'Mobile']/../../input");

    private static final By DROPDOWN_REPORT_TO = By.cssSelector("input[Title='Search Contacts']");

    private static final By INPUT_DEPARTMENT = By.xpath("//span[text() = 'Department']/../../input");
    private static final By INPUT_FAX = By.xpath("//span[text() = 'Fax']/../../input");

    private static final By INPUT_MAILING_STREET = By.cssSelector("textarea[placeholder='Mailing Street']");
    private static final By INPUT_MAILING_CITY = By.cssSelector("input[placeholder='Mailing City']");
    private static final By INPUT_MAILING_STATE = By.cssSelector("input[placeholder='Mailing State/Province']");
    private static final By INPUT_MAILING_ZIP = By.cssSelector("input[placeholder='Mailing Zip/Postal Code']");
    private static final By INPUT_MAILING_COUNTRY = By.cssSelector("input[placeholder='Mailing Country']");

    private static final By BUTTON_SAVE = By.cssSelector("button[title='Save']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillOutNewContactModal(Contact contact) {
        driver.findElement(DROPDOWN_SALUTATION).click();
        driver.findElement(By.xpath(String.format("//a[text()='%s']", contact.getSalutation()))).click();
        driver.findElement(INPUT_FIRST_NAME).sendKeys(contact.getFirstName());
        driver.findElement(INPUT_MIDDLE_NAME).sendKeys(contact.getMiddleName());
        driver.findElement(INPUT_LAST_NAME).sendKeys(contact.getLastName());
        driver.findElement(INPUT_SUFFIX).sendKeys(contact.getSuffix());
        driver.findElement(FIELD_SEARCH_ACCOUNT).click();
        driver.findElement(By.cssSelector(String.format("div[title='%s']", contact.getAccountName()))).click();

        driver.findElement(INPUT_TITLE).sendKeys(contact.getTitle());
        driver.findElement(INPUT_EMAIL).sendKeys(contact.getEmail());
        driver.findElement(INPUT_PHONE).sendKeys(contact.getPhone());
        driver.findElement(INPUT_MOBILE).sendKeys(contact.getMobile());

        driver.findElement(DROPDOWN_REPORT_TO).click();
        driver.findElement(By.cssSelector(String.format("div[title='%s']", contact.getReportsTo()))).click();

        driver.findElement(INPUT_DEPARTMENT).sendKeys(contact.getDepartment());
        driver.findElement(INPUT_FAX).sendKeys(contact.getFax());

        driver.findElement(INPUT_MAILING_STREET).sendKeys(contact.getMailingStreet());
        driver.findElement(INPUT_MAILING_CITY).sendKeys(contact.getMailingCity());
        driver.findElement(INPUT_MAILING_STATE).sendKeys(contact.getMailingState());
        driver.findElement(INPUT_MAILING_ZIP).sendKeys(contact.getMailingZip());
        driver.findElement(INPUT_MAILING_COUNTRY).sendKeys(contact.getMailingCountry());
    }

    public void saveContact() {
        driver.findElement(BUTTON_SAVE).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(BANNER_CONTACT));
    }
}

package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class ContactViewPage extends BasePage {
    private static final By TAB_DETAILS = By.xpath("//a[@data-label='Details' and @tabindex='-1']");
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

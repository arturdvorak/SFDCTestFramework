package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class ContactViewPage extends BasePage {
    private static final By detailsTab = By.xpath("//a[@data-label='Details' and @tabindex='-1']");

    private static final By nameField = By.xpath("//div/span[text()='Name']/../../div[2]/span/slot/slot/lightning-formatted-name");
    private static final By accountNameField = By.xpath("//span[text()='Account Name']/../../div[2]//a");
    private static final By titleField = By.xpath("//span[text()='Title']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By emailField = By.xpath("//span[text()='Email']/../../div[2]//a");
    private static final By phoneField = By.xpath("//span[text()='Phone']/../../div[2]//a");
    private static final By mobileField = By.xpath("//span[text()='Mobile']/../../div[2]//a");
    private static final By reportsToField = By.xpath("//span[text()='Reports To']/../../div[2]//a");
    private static final By departmentField = By.xpath("//span[text()='Department']/../../div[2]/span/slot/slot/lightning-formatted-text");
    private static final By faxField = By.xpath("//span[text()='Fax']/../../div[2]//a");
    private static final By addressStreetField = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[1]");
    private static final By addressCityStateZipField = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[2]");
    private static final By addressCountryField = By.xpath("//span[text()='Mailing Address']/../../div[2]//a/div[3]");

    public ContactViewPage(WebDriver driver) {
        super(driver);
    }

    public void validateContactData(Contact contact) {
        driver.findElement(detailsTab).click();
        assertEquals(driver.findElement(nameField).getText(),
                contact.getSalutation() + " "
                        + contact.getFirstName() + " "
                        + contact.getMiddleName() + " "
                        + contact.getLastName() + " "
                        + contact.getSuffix(),
                "Name is saved incorrectly.");
        assertEquals(driver.findElement(accountNameField).getText(), contact.getAccountName(),
                "Account Name is saved incorrectly.");
        assertEquals(driver.findElement(titleField).getText(), contact.getTitle(),
                "Title is saved incorrectly.");
        assertEquals(driver.findElement(emailField).getText(), contact.getEmail(),
                "Email is saved incorrectly.");
        assertEquals(driver.findElement(phoneField).getText(), contact.getPhone(),
                "Phone is saved incorrectly.");
        assertEquals(driver.findElement(mobileField).getText(), contact.getMobile(),
                "Mobile is saved incorrectly.");
        assertEquals(driver.findElement(reportsToField).getText(), contact.getReportsTo(),
                "Reports To is saved incorrectly.");
        assertEquals(driver.findElement(departmentField).getText(), contact.getDepartment(),
                "Department is saved incorrectly.");
        assertEquals(driver.findElement(faxField).getText(), contact.getFax(),
                "Fax is saved incorrectly.");
        assertEquals(driver.findElement(addressStreetField).getText(), contact.getMailingStreet(),
                "MailingStreet is saved incorrectly.");
        assertEquals(driver.findElement(addressCityStateZipField).getText(),
                contact.getMailingCity() + ", "
                        + contact.getMailingState() + " "
                        + contact.getMailingZip(),
                "CityStateZip is saved incorrectly.");
        assertEquals(driver.findElement(addressCountryField).getText(), contact.getMailingCountry(),
                "MailingCountry is saved incorrectly.");
    }

    public void closeContact() {
    }
}

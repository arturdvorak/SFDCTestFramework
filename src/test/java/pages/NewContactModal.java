package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModal extends BasePage {
    private static final By contactBanner = By.cssSelector("img[title='Contact']");

    private static final By salutationDropDown = By.cssSelector("div[class='uiPopupTrigger']");
    private static final By firstNameInput = By.cssSelector("input[placeholder='First Name']");
    private static final By middleNameInput = By.cssSelector("input[placeholder='Middle Name']");
    private static final By lastNameInput = By.cssSelector("input[placeholder='Last Name']");
    private static final By suffix = By.cssSelector("input[placeholder='Suffix']");

    private static final By fieldSearchAccount = By.cssSelector("input[title='Search Accounts']");

    private static final By title = By.xpath("//span[text() = 'Title']/../../input");
    private static final By email = By.xpath("//span[text() = 'Email']/../../input");
    private static final By phone = By.xpath("//span[text() = 'Phone']/../../input");
    private static final By mobile = By.xpath("//span[text() = 'Mobile']/../../input");

    private static final By reportToDropDown = By.cssSelector("input[Title='Search Contacts']");

    private static final By department = By.xpath("//span[text() = 'Department']/../../input");
    private static final By fax = By.xpath("//span[text() = 'Fax']/../../input");

    private static final By mailingStreet = By.cssSelector("textarea[placeholder='Mailing Street']");
    private static final By mailingCity = By.cssSelector("input[placeholder='Mailing City']");
    private static final By mailingState = By.cssSelector("input[placeholder='Mailing State/Province']");
    private static final By mailingZip = By.cssSelector("input[placeholder='Mailing Zip/Postal Code']");
    private static final By mailingCountry = By.cssSelector("input[placeholder='Mailing Country']");

    private static final By buttonSave = By.cssSelector("button[title='Save']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillOutNewContactModal(Contact contact) {
        driver.findElement(salutationDropDown).click();
        driver.findElement(By.xpath(String.format("//a[text()='%s']", contact.getSalutation()))).click();
        driver.findElement(firstNameInput).sendKeys(contact.getFirstName());
        driver.findElement(middleNameInput).sendKeys(contact.getMiddleName());
        driver.findElement(lastNameInput).sendKeys(contact.getLastName());
        driver.findElement(suffix).sendKeys(contact.getSuffix());
        driver.findElement(fieldSearchAccount).click();
        driver.findElement(By.cssSelector(String.format("div[title='%s']", contact.getAccountName()))).click();

        driver.findElement(title).sendKeys(contact.getTitle());
        driver.findElement(email).sendKeys(contact.getEmail());
        driver.findElement(phone).sendKeys(contact.getPhone());
        driver.findElement(mobile).sendKeys(contact.getMobile());

        driver.findElement(reportToDropDown).click();
        driver.findElement(By.cssSelector(String.format("div[title='%s']", contact.getReportsTo()))).click();

        driver.findElement(department).sendKeys(contact.getDepartment());
        driver.findElement(fax).sendKeys(contact.getFax());

        driver.findElement(mailingStreet).sendKeys(contact.getMailingStreet());
        driver.findElement(mailingCity).sendKeys(contact.getMailingCity());
        driver.findElement(mailingState).sendKeys(contact.getMailingState());
        driver.findElement(mailingZip).sendKeys(contact.getMailingZip());
        driver.findElement(mailingCountry).sendKeys(contact.getMailingCountry());
    }

    public void saveContact() {
        driver.findElement(buttonSave).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(contactBanner));
    }
}

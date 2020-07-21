package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private WebDriver driver;
    final String contactArrowXpath = "//*[@data-id=\"Contact\"]/one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button";
    final String newContactXpath = "//span[text()=\"New Contact\"]";

    @FindBy(xpath = contactArrowXpath)
    private WebElement contactArrow;

    @FindBy(xpath = newContactXpath)
    private WebElement newContact;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openNewContactDialog() {
        contactArrow.click();
        newContact.click();
    }
}

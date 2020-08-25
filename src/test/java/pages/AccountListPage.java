package pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListPage extends BasePage {
    private static final String URL_ACCOUNT_TAB = "https://ap16.lightning.force.com/lightning/o/Account/list";
    private static final By BUTTON_NEW = By.cssSelector("a[title='New']");
    private static final By TITLE_ACCOUNT_IN_PANEL = By.xpath("//h1/div[text()='Account']");
    private static final By TITLE_NEW_ACCOUNT_IN_MODAL = By.xpath("//h2[text()='New Account']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL_ACCOUNT_TAB);
    }

    public void openNewAccountModal() {
        driver.findElement(BUTTON_NEW).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE_NEW_ACCOUNT_IN_MODAL)));
    }

    public String getAccountLink(Account account) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", account.getAccountName()))).getAttribute("href");
    }

    public void openAccount(Account account) {
        driver.get(getAccountLink(account));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_ACCOUNT_IN_PANEL));
    }
}

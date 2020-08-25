package steps;

import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.NewAccountModal;

public class AccountSteps {
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;

    public AccountSteps(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
    }

    public void createNewAccount(Account account) {
        accountListPage.openPage();
        accountListPage.openNewAccountModal();
        newAccountModal.fillOutNewContactModal(account);
        newAccountModal.saveAccount();
    }

}

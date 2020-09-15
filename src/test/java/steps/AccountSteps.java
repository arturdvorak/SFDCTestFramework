package steps;

import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.AccountViewPage;
import pages.NewAccountModal;

public class AccountSteps {
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;
    AccountViewPage accountViewPage;

    public AccountSteps(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
        accountViewPage = new AccountViewPage(driver);
    }

    public void createNewAccount(Account account) {
        accountListPage.openPage();
        accountListPage.openNewAccountModal();
        newAccountModal.fillOutNewContactModal(account);
        newAccountModal.saveAccount();
    }

    public void validationOfAccount(Account account) {
        accountListPage.openPage();
        accountListPage.openAccount(account);
        accountViewPage.validateAccountData(account);
    }

    public void updateAccount(Account account, Account account_updated) {
        accountListPage.openPage();
        accountListPage.openAccount(account);
        accountViewPage.updateOpenAccount(account_updated);
    }

    public void removeAccount(Account account_updated) {
        accountListPage.openPage();
        accountListPage.openAccount(account_updated);
        accountViewPage.deleteOpenedAccount();
    }

}

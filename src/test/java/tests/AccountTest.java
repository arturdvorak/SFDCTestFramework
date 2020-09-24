package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    Account account = AccountFactory.getAccount("Test1");
    Account account_updated = AccountFactory.getAccount("Test2");

    @Test
    public void createAndRemoveAccount() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        accountSteps.createNewAccount(account);
        accountSteps.validationOfAccount(account);
        accountSteps.updateAccount(account, account_updated);
        accountSteps.validationOfAccount(account_updated);
        accountSteps.removeAccount(account_updated);
    }
}

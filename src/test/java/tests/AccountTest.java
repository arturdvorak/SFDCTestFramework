package tests;

import com.github.javafaker.Faker;
import models.Account;
import org.testng.annotations.Test;

import java.util.Locale;

public class AccountTest extends BaseTest {
    Faker usFaker = new Faker(new Locale("en-US"));
    Account account = Account.builder()
            .accountName(usFaker.company().name())
            .type(usFaker.options().option("Analyst", "Customer", "Investor", "Integrator"))
            .website(usFaker.internet().domainName())
            .description(usFaker.company().catchPhrase())
            .parentAccount("Test1")
            .phone(usFaker.phoneNumber().cellPhone())
            .industry(usFaker.options().option("Banking", "Chemicals", "Apparel"))
            .employees(usFaker.number().numberBetween(0,999))
            .billingStreet(usFaker.address().streetName())
            .billingCity(usFaker.address().city())
            .billingState(usFaker.address().state())
            .billingZip(usFaker.address().zipCode())
            .billingCountry(usFaker.address().country())
            .mailingStreet(usFaker.address().streetName())
            .mailingCity(usFaker.address().city())
            .mailingState(usFaker.address().state())
            .mailingZip(usFaker.address().zipCode())
            .mailingCountry(usFaker.address().country())
            .build();

    Account account_updated = Account.builder()
            .accountName(usFaker.company().name())
            .type(usFaker.options().option("Analyst", "Customer", "Investor", "Integrator"))
            .website(usFaker.internet().domainName())
            .description(usFaker.company().catchPhrase())
            .parentAccount("Test2")
            .phone(usFaker.phoneNumber().cellPhone())
            .industry(usFaker.options().option("Banking", "Chemicals", "Apparel"))
            .employees(usFaker.number().numberBetween(0,999))
            .billingStreet(usFaker.address().streetName())
            .billingCity(usFaker.address().city())
            .billingState(usFaker.address().state())
            .billingZip(usFaker.address().zipCode())
            .billingCountry(usFaker.address().country())
            .mailingStreet(usFaker.address().streetName())
            .mailingCity(usFaker.address().city())
            .mailingState(usFaker.address().state())
            .mailingZip(usFaker.address().zipCode())
            .mailingCountry(usFaker.address().country())
            .build();


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

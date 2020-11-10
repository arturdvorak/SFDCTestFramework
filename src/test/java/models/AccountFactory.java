package models;

import com.github.javafaker.Faker;
import java.util.Locale;

//Factory pattern
public class AccountFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Account getAccount(String parentAccountName) {
        return Account.builder()
                .accountName(usFaker.company().name())
                .parentAccount(parentAccountName)
                .accountNumber(usFaker.number().numberBetween(0,99999))
                .accountSite(usFaker.internet().domainName())
                .type(usFaker.options().option("Prospect", "Other"))
                .industry(usFaker.options().option("Banking", "Chemicals", "Apparel"))
                .annualRevenue(usFaker.number().numberBetween(0,999999))
                .rating(usFaker.options().option("Hot", "Warm", "Cold"))
                .phone(usFaker.phoneNumber().cellPhone())
                .fax(usFaker.phoneNumber().cellPhone())
                .website(usFaker.internet().domainName())
                .tickerSymbol(usFaker.finance().bic())
                .ownership(usFaker.options().option("Public", "Private", "Subsidiary", "Other"))
                .employees(usFaker.number().numberBetween(0,999))
                .sicCode(usFaker.number().numberBetween(1000,9999))
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
                .customerPriority(usFaker.options().option("High", "Low", "Medium"))
                .numberOfLocations(usFaker.number().numberBetween(1,10))
                .active(usFaker.options().option("Yes", "No"))
                .sla(usFaker.options().option("Gold", "Silver", "Platinum", "Bronze"))
                .upsellOpportunity(usFaker.options().option("Yes", "No", "Maybe"))
                .description(usFaker.company().catchPhrase())
                .build();
    }
}

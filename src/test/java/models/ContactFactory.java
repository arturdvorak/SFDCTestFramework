package models;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ContactFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));
    static SimpleDateFormat formater = new SimpleDateFormat("MM-dd-yyyy");

    public static Contact getContact(String accountName, String department, String reportsTo) {
        return Contact.builder()
                .salutation(usFaker.options().option("Mr.", "Ms.", "Mrs.", "Dr.", "Prof."))
                .firstName(usFaker.name().firstName())
                .lastName(usFaker.name().lastName())
                .accountName(accountName)
                .title(usFaker.company().profession())
                .department(department)
                .birthdate(formater.format(usFaker.date().past(30000, TimeUnit.DAYS)))
                .reportsTo(reportsTo)
                .leadSorurce(usFaker.options().option("Web", "Other"))
                .phone(usFaker.phoneNumber().cellPhone())
                .homePhone(usFaker.phoneNumber().cellPhone())
                .mobile(usFaker.phoneNumber().cellPhone())
                .otherPhone(usFaker.phoneNumber().cellPhone())
                .fax(usFaker.phoneNumber().cellPhone())
                .email(usFaker.internet().emailAddress())
                .assistant(usFaker.name().fullName())
                .assistantPhone(usFaker.phoneNumber().cellPhone())
                .mailingStreet(usFaker.address().streetName())
                .mailingCity(usFaker.address().city())
                .mailingState(usFaker.address().state())
                .mailingZip(usFaker.address().zipCode())
                .mailingCountry(usFaker.address().country())
                .otherStreet(usFaker.address().streetName())
                .otherCity(usFaker.address().city())
                .otherState(usFaker.address().state())
                .otherZip(usFaker.address().zipCode())
                .otherCountry(usFaker.address().country())
                .lang(usFaker.options().option("Russian", "English", "Spanish"))
                .level(usFaker.options().option("Primary", "Secondary", "Tertiary"))
                .description(usFaker.company().catchPhrase())
                .build();
    }
}

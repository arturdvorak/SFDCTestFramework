package tests;

import com.github.javafaker.Faker;
import models.Contact;
import org.testng.annotations.Test;
import java.util.Date;
import java.util.Locale;

public class ContactTest extends BaseTest {
    Faker usFaker = new Faker(new Locale("en-US"));
    Contact contact = Contact.builder()
            .salutation("Mr.")
            .firstName(usFaker.name().firstName())
            .middleName("Test")
            .lastName(usFaker.name().lastName())
            .suffix(usFaker.name().suffix())
            .accountName("Test1")
            .title(usFaker.company().profession())
            .email(usFaker.internet().emailAddress())
            .phone(usFaker.phoneNumber().cellPhone())
            .mobile(usFaker.phoneNumber().cellPhone())
            .reportsTo("1HeadContact")
            .department("Test Department")
            .fax(usFaker.phoneNumber().cellPhone())
            .mailingStreet(usFaker.address().streetName())
            .mailingCity(usFaker.address().city())
            .mailingState(usFaker.address().state())
            .mailingZip(usFaker.address().zipCode())
            .mailingCountry(usFaker.address().country())
            .build();

    @Test
    public void createAndRemoveContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(contact);
        contactSteps.validationOfContact(contact);
        contactSteps.removeAccount(contact);
    }
}

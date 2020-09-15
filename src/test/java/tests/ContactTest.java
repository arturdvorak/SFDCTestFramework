package tests;

import com.github.javafaker.Faker;
import models.Contact;
import org.testng.annotations.Test;
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
            .reportsTo("HeadContact1")
            .department("Test Department")
            .fax(usFaker.phoneNumber().cellPhone())
            .mailingStreet(usFaker.address().streetName())
            .mailingCity(usFaker.address().city())
            .mailingState(usFaker.address().state())
            .mailingZip(usFaker.address().zipCode())
            .mailingCountry(usFaker.address().country())
            .build();

    Contact contact_updated = Contact.builder()
            .salutation("Ms.")
            .firstName(usFaker.name().firstName())
            .middleName("Test")
            .lastName(usFaker.name().lastName())
            .suffix(usFaker.name().suffix())
            .accountName("Test2")
            .title(usFaker.company().profession())
            .email(usFaker.internet().emailAddress())
            .phone(usFaker.phoneNumber().cellPhone())
            .mobile(usFaker.phoneNumber().cellPhone())
            .reportsTo("HeadContact2")
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
        contactSteps.updateContact(contact, contact_updated);
        contactSteps.validationOfContact(contact_updated);
        contactSteps.removeContact(contact_updated);
    }
}

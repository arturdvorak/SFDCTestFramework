package tests;

import models.Contact;
import org.testng.annotations.Test;
import java.util.Date;

public class ContactTest extends BaseTest {
    Date currentDate = new Date();
    Contact contact = Contact.builder()
            .salutation("Mr.")
            .firstName("FirstTest1")
            .middleName("MiddleTest1")
            .lastName("Contact" + currentDate)
            .suffix("Suf")
            .accountName("Test1")
            .title("Test Title")
            .email("test@gmail.com")
            .phone("929333666")
            .mobile("929333666")
            .reportsTo("HeadContact")
            .department("Test Department")
            .fax("929333666")
            .mailingStreet("Test Street")
            .mailingCity("TestCity")
            .mailingState("FL")
            .mailingZip("33666")
            .mailingCountry("USA")
            .build();

    @Test
    public void createAndRemoveContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(contact);
        contactSteps.removeAccount(contact.getLastName());
    }
}

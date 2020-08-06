package tests;

import models.Contact;
import org.testng.annotations.Test;

import java.util.Date;

public class ContactTest extends BaseTest {
    Date currentDate = new Date();
    Contact contact = new Contact(
            "Mr.",
            "FirstTest1",
            "MiddleTest1",
            "Contact" + currentDate,
            "Suf",
            "Test1",
            "Test Title",
            "test@gmail.com",
            "9293336666",
            "9293336666",
            "HeadContact",
            "QA",
            "9293336666",
            "Test Street",
            "Test City",
            "FL",
            "33333",
            "USA"
    );

    @Test
    public void createAndRemoveContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(contact);
        //contactSteps.removeAccount(contact.getLastName());
    }
}

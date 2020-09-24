package tests;

import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    Contact contact = ContactFactory.getContact("Test1", "Test1 Department", "HeadContact1");
    Contact contact_updated = ContactFactory.getContact("Test2", "Test2 Department", "HeadContact2");

    @Test
    public void createAndRemoveContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(contact);
        //contactSteps.validationOfContact(contact);
        //contactSteps.updateContact(contact, contact_updated);
        //contactSteps.validationOfContact(contact_updated);
        //contactSteps.removeContact(contact_updated);
    }
}

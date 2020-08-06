package tests;

import org.testng.annotations.Test;

import java.util.Date;

public class ContactTest extends BaseTest {
    Date currentDate = new Date();
    String lastNameContact = "Contact" + currentDate;

    @Test
    public void createAndRemoveContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(lastNameContact);
        contactSteps.removeAccount(lastNameContact);
    }
}

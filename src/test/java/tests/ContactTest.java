package tests;

import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    String lastNameContact = "Contact";

    @Test
    public void createNewContact() {
        loginSteps.open(login_url);
        loginSteps.login(username, password);
        contactSteps.createNewContact(lastNameContact);
    }
}

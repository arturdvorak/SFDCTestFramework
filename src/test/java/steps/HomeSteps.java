package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage;

    public HomeSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void createNewContact() {
        homePage.openNewContactDialog();
        homePage.fillOutContactDialogAndSave();
    }
}

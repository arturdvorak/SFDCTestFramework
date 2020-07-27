package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage;

    public HomeSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }
}

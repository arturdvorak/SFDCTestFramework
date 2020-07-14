package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends WebDriverCreator {
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER = "chromedriver.exe";
    private static final String driverPath = "src/test/resources/";

    public WebDriver factoryMethod() {
        System.setProperty(CHROME_PROPERTY, driverPath+CHROME_DRIVER);
        return new ChromeDriver();
    }
}

package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverCreator extends WebDriverCreator {
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER = "chromedriver.exe";
    private static final String driverPath = "src/test/resources/";
    private ChromeOptions options;

    public WebDriver factoryMethod() {
        System.setProperty(CHROME_PROPERTY, driverPath+CHROME_DRIVER);
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return options;
    }
}

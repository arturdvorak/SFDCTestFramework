package driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static java.lang.System.setProperty;

@Log4j2
public class ChromeDriverCreator extends WebDriverCreator {
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String driverPath = "src/test/resources";
    private ChromeOptions options;
    private static String osName = System.getProperty("os.name").toLowerCase();

    public WebDriver factoryMethod() {
        log.atInfo().log("OS is identified as '{}'", osName);
        if (osName.contains("win")) {
            log.atInfo().log("Driver path is {}",driverPath + "/chromedriver.exe");
            setProperty(CHROME_PROPERTY, driverPath + "/chromedriver.exe");
        } else if (osName.contains("mac")) {
            log.atInfo().log("Driver path is {}",driverPath + "/chromedriver");
            setProperty(CHROME_PROPERTY, driverPath + "/chromedriver");
        } else {
            log.atInfo().log("Driver path is {}",driverPath + "/linux/chromedriver");
            setProperty(CHROME_PROPERTY, driverPath + "/linux/chromedriver");
        }
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        return options;
    }
}

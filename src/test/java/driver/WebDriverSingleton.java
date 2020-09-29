package driver;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    public WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance(String browser_type) {
        if (null == driver) {
            driver = createDriver(browser_type);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createDriver(String browserType) {
        WebDriverCreator creator;
        switch (browserType) {
            case "FF":
                creator = new FirefoxDriverCreator();
                break;
            case "GC":
                creator = new ChromeDriverCreator();
                break;
            case "IE":
                creator = new InternetExplorerDriverCreator();
                break;
            default:
                creator = new ChromeDriverCreator();
        }
        driver = creator.factoryMethod();
        return driver;
    }
}
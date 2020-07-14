package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public static String getProperty(String propertiesValue) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/test/resources/config.properties");
            prop.load(input);

        } catch (IOException e) {
            System.out.println("Could not find config.properties");
        }

        return prop.getProperty(propertiesValue);
    }
}

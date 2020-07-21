package utils;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesReader {
    private static PropertiesReader instance = null;
    private String propName = "/config.properties";
    static Properties prop = null;

    private PropertiesReader() {
        try {
            prop = new Properties();
            prop.load(getClass().getResourceAsStream(propName));
        } catch (IOException e) {
            System.out.println("Could not find " + propName);
            e.printStackTrace();
        }
    }

    public static PropertiesReader getInstance(){
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }
}

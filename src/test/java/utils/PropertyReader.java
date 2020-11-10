package utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Consumer;

@Log4j2
public final class PropertyReader {
    private static String propertiesPath ="/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;

    private PropertyReader() {
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }

    public static Properties readProperties() {
        properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(properties.getProperty("config_file")!=null){
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties loadProperties() {
        return properties != null ? properties : readProperties();
    }

    public static Properties getProperties(String path) {
        propertiesPath = path;
        return readProperties();
    }

    public static String getProperty(String propertyName) {
        String propVal = loadProperties().getProperty(propertyName);
        log.atInfo().log("Getting property '{}' from file '{}'. Value: '{}'", propertyName, propertiesPath, propVal);
        return propVal;
    }

    public static String getFromEnvOrFile(String envVar, String fileVar) {
        String var = System.getenv().getOrDefault(envVar, getProperty(fileVar));
        log.atInfo().log("Property {}/{} is set to {}", envVar, fileVar, var);
        return var;
    }

    public static void fillAction(Consumer<String> action, String name) {
        Object prop = null;
        try {
            prop = getProperty(name);
        } catch (Exception ignore) {}
        if (prop != null && !prop.equals(""))
            action.accept(prop.toString());
    }
}

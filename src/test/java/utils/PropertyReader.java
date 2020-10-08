package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Consumer;

public final class PropertyReader {
    private static String propertiesPath ="/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;
    //private String propName = "/config.properties";

    private PropertyReader() {
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }

    public static Properties readProperties() throws IOException {
        properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) inputStream.close();
        }
        if(properties.getProperty("config_file")!=null){
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties loadProperties() throws IOException {
        return properties != null ? properties : readProperties();
    }

    public static Properties getProperties(String path) throws IOException {
        propertiesPath = path;
        return readProperties();
    }

    public static String getProperty(String propertyName) throws IOException {
        return loadProperties().getProperty(propertyName);
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

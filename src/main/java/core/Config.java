package core;

import org.testng.Reporter;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Config {
    private static Properties properties;
    private static String resourceFile = "/project.properties";

    private static void loadProperties(){
        properties = new Properties();
        InputStream in = Config.class.getResourceAsStream(resourceFile);

        try {
            properties.load(in);
            in.close();
        } catch (Exception e) {
            Reporter.log("Unable to read resource file", true);
            Reporter.log(e.getMessage(), true);
        }
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(propertyName);
    }

    public static String getBaseURL() {
        return getProperty("test.baseURL");
        //return System.getProperty("test.baseURL");
    }
}

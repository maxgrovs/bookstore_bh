package by.grovs.utils;

import java.io.InputStream;
import java.util.Properties;

public class Util {

   public String getPropertiesValue(String key) {
       String propertyValue = "";
        Properties properties = new Properties();


        try (InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("application.properties")) {

            properties.load(inputStream);
            propertyValue = properties.getProperty(key);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return propertyValue;
    }
}

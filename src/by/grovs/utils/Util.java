package by.grovs.utils;

import java.io.InputStream;
import java.util.Properties;


public class Util {

   public String getPropertiesValue(String key) {
       String propertyValue = "";
        Properties properties = new Properties();


        try (InputStream inputStream = Util.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            properties.load(inputStream);
            propertyValue = properties.getProperty(key);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return propertyValue;
    }

    public String getIsbn(){

        return "798-5-" + getRand5num() + "-" + getRand3num() + "-2";
    }

    int getRand3num(){

        int min = 100;
        int max = 999;
        max -= min;

        return ((int) (Math.random() * ++max)) + min;
    }
    int getRand5num(){

        int min = 10000;
        int max = 99999;
        max -= min;

        return ((int) (Math.random() * ++max)) + min;
    }

}

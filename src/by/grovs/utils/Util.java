package by.grovs.utils;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;


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


    public LocalDate getRandomDateOfPublication(){

        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

}

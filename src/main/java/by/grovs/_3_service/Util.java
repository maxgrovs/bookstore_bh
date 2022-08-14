package by.grovs._3_service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;


public class Util {

    private Util() {
    }

    private static final Util INSTANCE = new Util();

    public static Util getInstance() {
        return INSTANCE;
    }

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


    public BigDecimal getRandomCost(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

}

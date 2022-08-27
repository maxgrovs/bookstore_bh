package by.grovs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {


    private static Properties PROPERTIES = new Properties();


    static {
        try (InputStream inputStream = PropertiesHelper.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* static {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "resources", "application.properties"))) {

            PROPERTIES.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

}

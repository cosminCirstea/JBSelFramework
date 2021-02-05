package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private final Properties properties;

    public ReadProperties(final String filename) {
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/test/resources/" + filename + ".properties");
            properties.load(input);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

}

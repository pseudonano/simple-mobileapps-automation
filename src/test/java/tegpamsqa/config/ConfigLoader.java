package tegpamsqa.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public Properties loadProperties(String fileName) {
        Properties prop = new Properties();

        try (InputStream input = ConfigLoader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException(fileName + " not found");
            }

            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

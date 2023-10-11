package praktikum.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

        private static final String CONFIG_FILE = "src/test/resources/config.properties";
        private static final Properties properties;

        static {
            properties = new Properties();
            try {
                FileInputStream inputStream = new FileInputStream(CONFIG_FILE);
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getBaseUri() {
            return properties.getProperty("base_uri");
        }
    }


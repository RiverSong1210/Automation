package com.tutorialspoint.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorialspoint.data.TestData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * A utility class to load configurations and test data
 * from JSON or properties files.
 */
public class ConfigManager {




        //private static final String JSON_CONFIG_PATH = "C:\\devtools\\Automation\\src\\test\\resources\\config\\test-config.json";
        private static final String JSON_CONFIG_PATH = "src/test/resources/config/test-config.json";


        public static TestConfig loadJsonConfig() {
            try (BufferedReader reader = new BufferedReader(new FileReader(JSON_CONFIG_PATH))) {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(reader, TestConfig.class);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load JSON config file: " + JSON_CONFIG_PATH, e);
            }
        }

    public static TestData loadTestData() {
        String path = "C:\\devtools\\Automation\\src\\test\\resources\\config\\test-data.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, TestData.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test-data.json", e);
        }
    }

}






    // Example method to read from JSON config
//    public static TestConfig loadJsonConfig() {
//        try (//InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(JSON_CONFIG_PATH))
//                InputStream is = ConfigManager.class.getResourceAsStream(JSON_CONFIG_PATH))
//        {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(is, TestConfig.class);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load JSON config file: " + JSON_CONFIG_PATH, e);
//        }
//    }

    // Example method to read from properties file
//    public static Properties loadPropertiesConfig() {
//        try (InputStream is = ConfigManager.class.getResourceAsStream(PROPERTIES_CONFIG_PATH)) {
//            Properties props = new Properties();
//            props.load(is);
//            return props;
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load properties file: " + PROPERTIES_CONFIG_PATH, e);
//        }
//    }


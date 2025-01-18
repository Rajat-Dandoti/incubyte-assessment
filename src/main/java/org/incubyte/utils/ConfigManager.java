package org.incubyte.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ConfigManager {

    private static final Properties properties = new Properties();
    private static final Properties locators = new Properties();
    private static final Logger logger = Logger.getLogger(ConfigManager.class.getName());

    static {
        loadProperties();
        loadLocators();
    }

    private static void loadProperties() {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                logger.log(Level.SEVERE, "Sorry, unable to find " + "application.properties");
            } else {
                ConfigManager.properties.load(input);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error loading " + "application.properties", ex);
        }
    }

    private static void loadLocators() {
        try (Stream<Path> paths = Files.walk(Paths.get("src/test/resources"))) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".loc"))
                    .forEach(ConfigManager::loadLocatorFile);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error walking through .loc files", ex);
        }
    }

    private static void loadLocatorFile(Path path) {
        try (InputStream input = Files.newInputStream(path)) {
            locators.load(input);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error loading " + path, ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static String getLocator(String key) {
        return locators.getProperty(key);
    }

}

package com.design.patterns;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfig {

    private static ServerConfig instance;

    private static String configFilePath = "/server-config.properties";

    private Properties properties;


    public static ServerConfig getInstance() {
        if (instance == null) {
            instance = new ServerConfig();
        }
        return instance;
    }

    private ServerConfig() {
        properties = new Properties();
        loadConfig();
        validateConfig();
    }

    private void loadConfig() {
        try(InputStream input = getClass().getResourceAsStream(configFilePath)) {
            if (input == null){
                throw new IOException("Config file not found");
            }
            properties.load(input);
        } catch (IOException ex){
            throw new RuntimeException("Failed to load Config file");
        }
    }
    private void validateConfig(){
        if (properties.getProperty("access.level.admin") == null ||
                properties.getProperty("access.level.user") == null ||
                properties.getProperty("access.level.guest") == null) {
            throw new IllegalStateException("Missing required configuration properties");
        }
    }
    public String getAccessLevel(User user) {
        return properties.getProperty("access.level." + user.getRole());
    }

}

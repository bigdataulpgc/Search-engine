package controller;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class Configuration {

    private static final String PROPERTIES_FILE = "./config.properties";

    public Scheduler readConfigurationFile() throws IOException {

        Properties properties = new Properties();
        try (InputStream stream = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int id_init = Integer.parseInt(properties.getProperty("id_init"));
        int iterations = Integer.parseInt(properties.getProperty("iterations"));
        int delay = Integer.parseInt(properties.getProperty("delay"));
        String source = properties.getProperty("source");

        Scheduler scheduler = new Scheduler(delay, id_init, iterations, source);

        return scheduler;
    }
}

package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final String PROPERTIES_FILE = ".\\crawler\\target\\classes\\config.properties";

    public Scheduler readConfigurationFile() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader(PROPERTIES_FILE));
        int id_init = Integer.parseInt(properties.getProperty("id_init"));
        int iterations = Integer.parseInt(properties.getProperty("iterations"));
        int delay = Integer.parseInt(properties.getProperty("delay"));
        String source = properties.getProperty("source");

        Scheduler scheduler = new Scheduler(delay, id_init, iterations, source);

        return scheduler;
    }
}

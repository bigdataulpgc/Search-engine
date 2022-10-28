package init;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        final String PROPERTIES_FILE = "target\\classes\\config.properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(PROPERTIES_FILE));
        } catch (IOException e) {
            System.out.println("Problemas al leer fichero de configuración.");
            System.exit(-1);
        }
        int delay = Integer.parseInt(properties.getProperty("delay"));
        int period = Integer.parseInt(properties.getProperty("period"));
        String source = properties.getProperty("source");

        Scheduler scheduler = new Scheduler(delay, period, source);
    }
}


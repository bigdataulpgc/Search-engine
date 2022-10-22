package utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class UrlReader {

    public URL url;

    public UrlReader(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public String getContentUrl() throws IOException {
        String text;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(this.url.openStream()))) {
            text = reader.lines().collect(Collectors.joining("\n"));
        }
        return text;
    }
}

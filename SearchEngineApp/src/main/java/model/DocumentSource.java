package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DocumentSource implements Source{

    public String loader(String word) throws IOException {

        URL url = new URL(getUrl(word));
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String content = "";
        String linea = br.readLine();
        while (null != linea) {
            content += linea;
            linea = br.readLine();
        }
        return content;
    }

    private String getUrl(String word) {
        return "http://localhost:4567/documents/" + word;
    }
}

package web_connection;

import org.jsoup.Jsoup;
import java.io.IOException;

public class GutenbergSource implements Source {

    @Override
    public String bookLoader(int bookId) throws IOException {

        String text = Jsoup.connect(getUrl(bookId))
                .execute()
                .body();
        return text;
    }

    private String getUrl(int bookId) {
        return "https://www.gutenberg.org/files/"+bookId+"/"+bookId+"-0.txt";
    }
}

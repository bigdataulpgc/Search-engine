import org.jsoup.Jsoup;
import java.io.IOException;

public class GutenbergSource implements Source {

    @Override
    public String bookDownloader(int numberOfBook) throws IOException {
        String url = "https://www.gutenberg.org/files/"+numberOfBook+"/"+numberOfBook+"-0.txt";
        //String url = "https://www.gutenberg.org/files/11/11-0.txt";
        String text = Jsoup.connect(url)
                .execute()
                .body();
        return text;
    }
}
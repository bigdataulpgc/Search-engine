import org.junit.Test;
import java.io.IOException;


public class BookLoaderTest {

    int BOOK_ID = 1;
    int[] BOOKS_IDS = {1,10};

    @Test
    public void book_loader() throws IOException {
        GutenbergSource gutenbergSource = new GutenbergSource();
        String a = gutenbergSource.bookLoader(BOOK_ID);
        System.out.println(a);
    }

    @Test
    public void multi_book_loader() throws IOException {

        GutenbergSource gutenbergSource = new GutenbergSource();

        for (int book_id : BOOKS_IDS) {
            String a = gutenbergSource.bookLoader(book_id);
            System.out.println(a);
        }
    }

    @Test
    public void get_content() throws IOException {
        GutenbergSource gutenbergSource = new GutenbergSource();
        String a = gutenbergSource.bookLoader(BOOK_ID);
        System.out.println(a);
    }
}
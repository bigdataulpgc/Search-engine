package tests;
import webconnection.GutenbergSource;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class should_check_book_loader {

    private final static Logger LOGGER = Logger.getLogger("tests.should_check_book_loader");

    String book = null;

    @Test
    public void one_book_loader() throws IOException {
        int BOOK_ID = 11;

        GutenbergSource gutenbergSource = new GutenbergSource();
        book = gutenbergSource.bookLoader(BOOK_ID);
    }

    @Test
    public void multi_book_loader() {
        
        LOGGER.setLevel(Level.INFO);

        int BOOK_ID_INIT = 1;
        int BOOK_ID_END = 10;

        ArrayList id_of_books_that_do_not_exist = new ArrayList();

        GutenbergSource gutenbergSource = new GutenbergSource();

        for(int id = BOOK_ID_INIT; id<BOOK_ID_END; id++) {
            try {
                book = gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                id_of_books_that_do_not_exist.add(id);
                continue;
            }
        }

        LOGGER.log(Level.FINE, "There are no books with id: " + id_of_books_that_do_not_exist);

    }
}
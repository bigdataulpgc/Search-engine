package tests;
import web_connection.GutenbergSource;
import org.junit.Test;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class should_check_book_loader {

    private static final Logger LOGGER = Logger.getLogger("tests.should_check_book_loader");
    private static final int BOOK_ID_INIT = 1;
    private static final int BOOK_ID_END = 10;

    String book = null;

    @Test
    public void multi_book_loader() {

        LOGGER.setLevel(Level.INFO);

        ArrayList notValidId = new ArrayList();
        GutenbergSource gutenbergSource = new GutenbergSource();

        for(int id = BOOK_ID_INIT; id < BOOK_ID_END; id++) {
            try {
                book = gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                notValidId.add(id);
            }
        }

        LOGGER.log(Level.FINE, "There are no books with id: " + notValidId);

    }
}
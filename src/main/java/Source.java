import java.io.IOException;

public interface Source {
    String bookLoader(int bookId) throws IOException;
}

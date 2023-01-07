package inverted_index.implementation;

import java.util.List;
import java.util.Map;

public interface InvertedIndex {

    String serialize(String word, String book);
    void addBook(String word, String id, int nLine);
    String[] getBooks(String word);
    List<Integer> getLines(String word, String id);
}

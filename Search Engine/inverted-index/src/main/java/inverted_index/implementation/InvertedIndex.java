package inverted_index.implementation;

import java.util.List;

public interface InvertedIndex {

    void addBook(String word, String id, int nLine);
    String serialize(String word);
    String[] getBooks(String word);
    List<Integer> getLines(String word, String id);
}

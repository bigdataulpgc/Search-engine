package api.operations.words;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface BooksGetter {

    Set<String> getBooks(List<String> words);
}

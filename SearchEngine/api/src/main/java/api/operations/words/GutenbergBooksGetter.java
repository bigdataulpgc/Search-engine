package api.operations.words;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GutenbergBooksGetter implements BooksGetter{

    private static final String PATH = "/home/search-engine/disk/datamart/inverted_index/";

    @Override
    public Set<String> getBooks(List<String> words) {
        if (words.isEmpty()) return new HashSet<>();
        else if (hasWordsOneWord(words)) return getBooksOfWord(words.get(0));
        else {
            String word = words.remove(words.size() - 1);
            return getRepeatedBooks(getBooks(words), getBooksOfWord(word));
        }
    }

    private static HashSet<String> getRepeatedBooks(Set<String> actualBooks, Set<String> newBooks) {
        return actualBooks.stream()
                .filter(newBooks::contains)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static boolean hasWordsOneWord(List<String> words) {
        return words.size() == 1;
    }

    private static Set<String> getBooksOfWord(String word) {

        Set<String> books = new HashSet<>();
        try {
            for (File book : new File(PATH + word.charAt(0) + "/" + word).listFiles())
                books.add(getBookId(book));
        } catch (Exception ignored){}
        return books;
    }

    private static String getBookId(File file) {
        return file.getName().split("\\.")[0];
    }
}

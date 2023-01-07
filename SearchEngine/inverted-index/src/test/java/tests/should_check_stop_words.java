package tests;

import inverted_index.implementation.MapInvertedIndex;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class should_check_stop_words {


    @Test
    public void should_test_stop_words() {
        String[] toValidate = {"hi", "thats", "okey", "able", "about", "a", "across", "according", "after"};
        List<String> toCheck = processWords(toValidate);
        List<String> result = List.of("hi", "thats", "okey", "able", "according");
        Assertions.assertThat(toCheck).isEqualTo(result);
    }

    public static final Set<String> STOP_WORDS;

    static {
        try {
            STOP_WORDS = new HashSet<>(Files.readAllLines(Paths.get("..\\StopWords.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List processWords(String[] words){
        List<String> myArrayList = new ArrayList();
        for (String word : words) {
            if (isStopWord(word)) continue;
            if (isNull(word)) continue;
            myArrayList.add(word);
        }
        return myArrayList;
    }

    private static boolean isNull(String word) {
        return word.equals("");
    }

    private static boolean isStopWord(String word) {
        return STOP_WORDS.contains(word);
    }
}

package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class StopWords {

    private final String STOP_WORDS_PATH = "/home/search-engine/disk/stop_words/StopWords.txt";
    private final Set<String> stopWord;

    public StopWords(){
        try {
            this.stopWord = new HashSet<>(Files.readAllLines(Paths.get(STOP_WORDS_PATH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean containWord(String word){
        return stopWord.contains(word);
    }
}

package inverted_index.implementation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import classes.Document;
import utils.Tokenizer;

public class InvertedIndexBuilder {

    public static final Set<String> STOP_WORDS;

    static {
        try {
            STOP_WORDS = new HashSet<>(Files.readAllLines(Paths.get("..\\StopWords.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MapInvertedIndex invertedIndex;


    public InvertedIndexBuilder(MapInvertedIndex invertedIndex){
        this.invertedIndex = invertedIndex;
    }

    public void build(Document document) {

        Tokenizer tokenizer = new Tokenizer();
        int nLine = 0;
        for (String line: document.getContent().split("\n")){
            nLine++;
            this.processWords(tokenizer.tokenize(line), document.getSourceId(), nLine);
        }
    }

    private void processWords(String[] words, String id, int nLine){
        for (String word : words) {
            if (isStopWord(word)) continue;
            if (isNull(word)) continue;
            invertedIndex.addBook(word, id, nLine);
        }
    }

    private static boolean isNull(String word) {
        return word.equals("");
    }

    private static boolean isStopWord(String word) {
        return STOP_WORDS.contains(word);
    }
}

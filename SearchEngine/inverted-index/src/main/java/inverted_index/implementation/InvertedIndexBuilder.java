package inverted_index.implementation;

import documentclasses.Document;
import utils.StopWords;
import utils.Tokenizer;

public class InvertedIndexBuilder {

    private static final StopWords stopWords = new StopWords();

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
        return stopWords.containWord(word);
    }
}

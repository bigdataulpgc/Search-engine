package tests;
import org.junit.Test;
import program.InvertedIndex;
import program.InvertedIndexStore;


public class should_make_inverted_index_persister {

    InvertedIndex invertedIndex = new InvertedIndex();

    String[] documents = {"document1","document2", "document2", "document3", "document1", "document3", "document1", "document2", "document1"};
    String[] words = {"word1", "word2", "pword3", "word1", "word1", "pword1", "word2", "word1", "hword2"};
    int[] lines = {1, 2, 3, 4, 5, 6, 7, 8,9};

    @Test
    public void make_diccionary() {
        for (int i=0;i<words.length;i++)  invertedIndex.addWord(words[i], documents[i], lines[i]);
        System.out.println(invertedIndex.serialize());
    }

    @Test
    public void make_persister() {
        String path = "/Users/albaamaarrtin3/Desktop/Crawler-development/Json";
        for (int i=0;i<words.length;i++)  invertedIndex.addWord(words[i], documents[i], lines[i]);
        new InvertedIndexStore(invertedIndex.getInvertedIndex()).store(path);
    }
}
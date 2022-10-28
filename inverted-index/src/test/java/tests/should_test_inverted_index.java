package tests;

import crawler.builder.Document;
import inverted_index.Controller;
import inverted_index.DocumentDeserialize;
import inverted_index.InvertedIndex;
import org.junit.Test;

public class should_test_inverted_index {

    @Test
    public void testInvertedIndex(){

        InvertedIndex invertedIndex = new InvertedIndex();
        Document[] books = new DocumentDeserialize().getDocuments();
        Controller controller = new Controller();
        controller.invertedIndexOf(invertedIndex, books);
    }
}

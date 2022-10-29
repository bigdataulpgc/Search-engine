package tests;

import classes.Document;
import org.junit.Test;
import program.Controller;
import program.DocumentDeserialize;
import program.InvertedIndex;

public class should_test_inverted_index {

    @Test
    public void testInvertedIndex(){

        InvertedIndex invertedIndex = new InvertedIndex();
        Document[] books = new DocumentDeserialize().getDocuments();
        Controller controller = new Controller();
        //controller.invertedIndexOf(invertedIndex, books);
    }
}

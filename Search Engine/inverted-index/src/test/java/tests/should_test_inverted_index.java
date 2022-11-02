package tests;

import classes.Document;
import inverted_index.implementation.MapInvertedIndex;
import org.junit.Test;
import utils.Controller;
import documents.DocumentDeserialize;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class should_test_inverted_index {

    @Test
    public void testInvertedIndex() throws FileNotFoundException {

        DocumentDeserialize documentDeserialize = new DocumentDeserialize();
        List<Document> documents = documentDeserialize.getDocuments();

        Controller controller = new Controller();

        List<Document> documentList = new ArrayList<>();

        for(int i = 0; i < 10; i++)
            documentList.add(documents.get(i));

        controller.invertedIndexOf(new MapInvertedIndex(), documentList);

    }
}

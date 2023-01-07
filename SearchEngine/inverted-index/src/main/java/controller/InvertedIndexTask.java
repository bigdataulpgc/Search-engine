package controller;

import documentclasses.Document;
import documents.DocumentDeserialize;
import documents.IndexedId;
import inverted_index.implementation.MapInvertedIndex;
import java.util.List;
import java.util.TimerTask;

public class InvertedIndexTask extends TimerTask {

    private static final IndexedId indexedId = new IndexedId();

    @Override
    public void run() {

        List<Document> documents = getDocuments();
        if (!documents.isEmpty()) {
            Controller controller = new Controller(indexedId);
            controller.invertedIndexOf(new MapInvertedIndex(), documents);
        }
    }

    private static List<Document> getDocuments() {
        DocumentDeserialize documentDeserialize = new DocumentDeserialize(indexedId);
        return documentDeserialize.getDocuments();
    }
}

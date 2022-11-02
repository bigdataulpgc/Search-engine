package utils;

import classes.Document;
import inverted_index.implementation.InvertedIndexBuilder;
import inverted_index.implementation.MapInvertedIndex;
import inverted_index.storage.InvertedIndexStore;

import java.util.List;

public class Controller {

    public void invertedIndexOf(MapInvertedIndex invertedIndex, List<Document> documents) {

        InvertedIndexBuilder invertedIndexBuilder = new InvertedIndexBuilder(invertedIndex);

        for (Document document: documents) {
            invertedIndexBuilder.build(document);
        }

        new InvertedIndexStore(invertedIndex).store();
    }
}

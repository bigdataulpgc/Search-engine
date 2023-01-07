package controller;

import documentclasses.Document;
import documents.IndexedId;
import inverted_index.implementation.InvertedIndexBuilder;
import inverted_index.implementation.MapInvertedIndex;
import inverted_index.storage.InvertedIndexStore;

import java.util.List;

public class Controller {

    private IndexedId indexedId;

    public Controller(IndexedId indexedId) {
        this.indexedId = indexedId;
    }

    public void invertedIndexOf(MapInvertedIndex invertedIndex, List<Document> documents) {

        InvertedIndexBuilder invertedIndexBuilder = new InvertedIndexBuilder(invertedIndex);

        for (Document document: documents) {
            invertedIndexBuilder.build(document);
            indexedId.addIndexedId(document.getSourceId());
        }

        new InvertedIndexStore(invertedIndex).store();
    }

    private boolean documentIsIndexed(String id) {
        return indexedId.isIdIndexed(id);
    }
}

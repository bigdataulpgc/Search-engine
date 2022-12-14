package storage;

import documentclasses.Document;

import java.io.IOException;

public interface DocumentStore {
    void store(Document document, int id) throws IOException;
}
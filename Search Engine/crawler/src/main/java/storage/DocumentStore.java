package storage;

import classes.Document;

import java.io.IOException;

public interface DocumentStore {
    void store(Document document, int id) throws IOException;
}
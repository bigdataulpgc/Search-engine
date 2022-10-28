package file_system;

import classes.Document;

import java.io.IOException;

public interface Store {
    void store(Document document) throws IOException;
}
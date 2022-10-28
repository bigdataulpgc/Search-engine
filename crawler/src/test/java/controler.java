import classes.Document;
import document_builder.GutenbergDocumentBuilder;
import file_system.FileSystemStore;
import org.junit.Test;
import utils.UrlReader;

import java.io.IOException;

public class controler {
    @Test
    public void persister_test() {
        String text;
        try {
            text = new UrlReader("https://www.gutenberg.org/files/69169/69169-0.txt").getContentUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GutenbergDocumentBuilder documentBuilder;
        try {
            documentBuilder = new GutenbergDocumentBuilder(text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Document document = documentBuilder.build();

            FileSystemStore fileSystemStore = new FileSystemStore("/Users/albaamaarrtin3/Desktop/Search-engine/Datalake");
            fileSystemStore.store(document);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

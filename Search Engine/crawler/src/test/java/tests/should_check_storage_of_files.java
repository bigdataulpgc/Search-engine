package tests;

import classes.Document;
import document_builder.GutenbergDocumentBuilder;
import storage.FileSystemStore;
import org.junit.Test;
import web_connection.GutenbergSource;


public class should_check_storage_of_files {

    private static final int BOOK_ID = 69198;

    @Test
    public void should_check_storage_of_files() throws Exception {

        GutenbergSource gutenbergSource = new GutenbergSource();
        String book = gutenbergSource.bookLoader(BOOK_ID);

        GutenbergDocumentBuilder documentBuilder = new GutenbergDocumentBuilder(book, BOOK_ID);
        Document document = documentBuilder.build();

        FileSystemStore fileSystemStore = new FileSystemStore();
        fileSystemStore.store(document, BOOK_ID);
    }
}
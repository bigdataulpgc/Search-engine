package tests;

import classes.Document;
import document_builder.GutenbergDocumentBuilder;
import file_system.FileSystemStore;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import webconnection.GutenbergSource;

import java.nio.file.Files;
import java.nio.file.Path;


public class should_check_storage_of_files {

    int BOOK_ID = 11;
    GutenbergSource gutenbergSource = new GutenbergSource();
    String book = gutenbergSource.bookLoader(BOOK_ID);

    GutenbergDocumentBuilder documentBuilder = new GutenbergDocumentBuilder(book);
    Document document = documentBuilder.build();


    public should_check_storage_of_files() throws Exception {
    }

    @Test
    public void should_check_storage_of_files() {
        FileSystemStore fileSystemStore = new FileSystemStore("/Users/victo/Desktop/Search-engine/Datalake");
        fileSystemStore.store(document);
        boolean exists1 = Files.exists(Path.of("/Users/victo/Desktop/Search-engine/Datalake/1"));
        Assertions.assertThat(exists1).isTrue();
    }
}

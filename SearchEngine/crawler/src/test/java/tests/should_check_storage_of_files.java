package tests;

import documentclasses.Document;
import document_builder.GutenbergDocumentBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import storage.FileSystemStore;
import org.junit.Test;
import web_connection.GutenbergSource;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class should_check_storage_of_files {


    public String intialPath;
    private static final int BOOK_ID = 69198;

    public should_check_storage_of_files(String intialPath) {
        this.intialPath = intialPath;
    }

    @Test
    public void should_check_storage_of_files(String args[]) throws Exception {

        GutenbergSource gutenbergSource = new GutenbergSource();
        String book = gutenbergSource.bookLoader(BOOK_ID);

        GutenbergDocumentBuilder documentBuilder = new GutenbergDocumentBuilder(book, BOOK_ID);
        Document document = documentBuilder.build();

        FileSystemStore fileSystemStore = new FileSystemStore();
        fileSystemStore.store(document, BOOK_ID);
    }

    @Parameterized.Parameters
    public static List<String> parameters(){
        return Arrays.asList("C:/Users/Joel/Documents/Universidad/Tercer curso/Primer Semestre/Big Data/Practicas/Search Engine");
    }
}
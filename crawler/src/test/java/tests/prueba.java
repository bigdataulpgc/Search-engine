package tests;

import document_builder.GutenbergDocumentBuilder;
import org.junit.Test;
import utils.UrlReader;

import java.io.IOException;

public class prueba {

    @Test
    public void eke() {

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
            System.out.println(documentBuilder.build().getContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package tests;

import builder.Document;
import builder.Metadata;
import builder.MetadataExtractor;
import org.junit.Test;
import utils.UrlReader;

import java.io.IOException;

public class should_check_extraction_of_metadata {

    @Test
    public void testExtraction(){
        String text;
        try {
            text = new UrlReader("https://www.gutenberg.org/files/69199/69199-0.txt").getContentUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Document document = new MetadataExtractor(text).extract();
    }
}

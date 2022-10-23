package tests;

import builder.Document;
import builder.Metadata;
import builder.MetadataExtractor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import utils.UrlReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class should_check_extraction_of_metadata {

    @Test
    public void testExtraction(){
        String text;
        try {
            text = new UrlReader("https://www.gutenberg.org/files/69199/69199-0.txt").getContentUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Metadata metadata;

        try {
            metadata = new MetadataExtractor(text).getMetadata();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(metadata.getTitle()).isEqualTo("A bird of passage");
        Assertions.assertThat(metadata.getAuthors().get(0)).isEqualTo("Bithia Mary Croker");
        Assertions.assertThat(metadata.getLanguage()).isEqualTo("English");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Assertions.assertThat(metadata.getAuthors()).isEqualTo(formato.parse("21/11/2022"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertThat(metadata.getAuthors()).isNull();
    }
}

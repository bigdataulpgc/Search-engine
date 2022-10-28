package tests;

import classes.Metadata;
import document_builder.GutenbergMetadataExtractor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import webconnection.GutenbergSource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class should_check_extraction_of_metadata {

    @Test
    public void testExtraction(){
        String text;
        try {
            text = new GutenbergSource().bookLoader(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Metadata metadata;

        try {
            metadata = new GutenbergMetadataExtractor(text).getMetadata();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(metadata.getTitle()).isEqualTo("A bird of passage");
        Assertions.assertThat(metadata.getAuthors().get(0)).isEqualTo("Bithia Mary Croker");
        Assertions.assertThat(metadata.getLanguage()).isEqualTo("English");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Assertions.assertThat(metadata.getReleaseDate()).isEqualTo(formato.parse("21/10/2022"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertThat(metadata.getPostingDate()).isNull();
    }
}

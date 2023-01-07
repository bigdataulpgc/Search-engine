package tests;

import documentclasses.Metadata;
import document_builder.GutenbergMetadataExtractor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import web_connection.GutenbergSource;

import java.io.IOException;

public class should_check_extraction_of_metadata {

    @Test
    public void testExtraction(){
        String text;
        try {
            text = new GutenbergSource().bookLoader(69198);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Metadata metadata;

        try {
            metadata = new GutenbergMetadataExtractor(text).extractMetadata();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(metadata.getMetadata().get("Title").get(0)).isEqualTo("A bird of passage");
        Assertions.assertThat(metadata.getMetadata().get("Author").get(0)).isEqualTo("Bithia Mary Croker");
        Assertions.assertThat(metadata.getMetadata().get("Language").get(0)).isEqualTo("English");
        Assertions.assertThat(metadata.getMetadata().get("Release Date").get(0)).isEqualTo("October 21, 2022");


    }
}

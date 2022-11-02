package tests;

import classes.Document;
import classes.Metadata;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import documents.DocumentDeserialize;

import java.io.FileNotFoundException;
import java.util.List;

public class should_test_deserialized_books {

    @Test
    public void testDeserializedBooks() throws FileNotFoundException {

        DocumentDeserialize documentDeserialize = new DocumentDeserialize();
        List<Document> documents = documentDeserialize.getDocuments();
        Metadata metadata = documents.get(0).getMetadata();

        Assertions.assertThat(metadata.getMetadata().get("Title").get(0)).isEqualTo("A bird of passage");
        Assertions.assertThat(metadata.getMetadata().get("Author").get(0)).isEqualTo("Bithia Mary Croker");
        Assertions.assertThat(metadata.getMetadata().get("Language").get(0)).isEqualTo("English");
        Assertions.assertThat(metadata.getMetadata().get("Release Date").get(0)).isEqualTo("October 21, 2022");
    }
}

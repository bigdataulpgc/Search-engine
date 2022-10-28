package program;
import classes.Document;
import classes.Metadata;
import com.google.gson.JsonObject;
import java.util.Date;

public class DocumentBuilder {


    public Document build(JsonObject deserialized_document) {
        Metadata metadata = new Metadata()
                .setId(deserialized_document.get("id").getAsInt())
                .setTitle(deserialized_document.get("title").getAsString())
                .setLanguage(deserialized_document.get("release_date").getAsString())
                .setPostingDate(new Date(deserialized_document.get("posting_date").getAsString()))
                .setReleaseDate(new Date(deserialized_document.get("language").getAsString()));

        String[] authors = deserialized_document.get("author").getAsString().split(",");

        for (int i=0; i<authors.length; i++) {
            metadata.addAuthors(authors[i]);
        }

        Document document = new Document()
                .setMetadata(metadata)
                .setContent(document_name_generator(String.valueOf(metadata.getId())));

        return document;
    }

    public String document_name_generator(String name_document) {
        return "../../books/txt/pg" + name_document + ".txt";
    }
}
package program;
import classes.Document;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DocumentReader {

    String name_document;
    DocumentBuilder document_builder;
    public DocumentReader(String name_document) {
        this.name_document = name_document;
        this.document_builder = new DocumentBuilder();
    }

    public Document read_document() {
        JsonObject deserialized_document = deserializer();
        Document document = this.document_builder.build(deserialized_document);
        return document;
    }

    public JsonObject deserializer() {
        JsonObject object = new Gson().fromJson(this.name_document, JsonObject.class);
        return object;
    }

}


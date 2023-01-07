package documents;

import documentclasses.Document;

import java.io.File;
import java.io.FileNotFoundException;

public class DocumentBuilder {

    private JsonMetadataDeserializer jsonMetadataDeserializer;
    private FileReader fileReader;

    public DocumentBuilder() {
        this.jsonMetadataDeserializer = new JsonMetadataDeserializer();
        this.fileReader = new FileReader();
    }

    public Document build(String path) throws FileNotFoundException {

        String[] filesDocument = new File(path).list();
        Document document = new Document().setMetadata(jsonMetadataDeserializer
                        .deserialize(fileReader.read(new File(path + "/" + filesDocument[0]))))
                .setContent(fileReader.read(new File(path + "/" + filesDocument[1])))
                .setSourceId(filesDocument[0].split("\\.")[0]);

        return document;
    }
}

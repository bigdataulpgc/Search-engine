package document_builder;

import classes.Document;
import classes.Metadata;
import java.util.UUID;

public class GutenbergDocumentBuilder implements DocumentBuilder {

    private String[] arrayText;
    private int sourceId;

    public GutenbergDocumentBuilder(String text, int sourceId){
        this.arrayText = text.split("\\*\\*\\*");
        this.sourceId = sourceId;

    }

    public Document build() throws Exception {
        Document document = new Document();
        Metadata metadata = new GutenbergMetadataExtractor(this.arrayText[0]).extractMetadata();
        document.setMetadata(metadata)
                .setContent(this.extractContent())
                .setSourceId(createSourceId(sourceId));
        return document;
    }

    private String extractContent() {
        String content = this.arrayText[2];
        return content;
    }

    public String createSourceId(int id) {
        String uid = UUID.randomUUID().toString();
        return uid;
    }
}

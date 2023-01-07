package document_builder;

import documentclasses.Document;
import documentclasses.Metadata;
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
                .setSourceId(createSourceId());
        return document;
    }

    private String extractContent() {
        String content = this.arrayText[2];
        return content;
    }

    public String createSourceId() {
        String uid = UUID.randomUUID().toString();

        return uid;
    }
}

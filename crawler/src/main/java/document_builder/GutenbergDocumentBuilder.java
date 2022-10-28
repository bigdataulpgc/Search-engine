package document_builder;

public class GutenbergDocumentBuilder implements DocumentBuilder{

    public String[] arrayText;

    public GutenbergDocumentBuilder(String text){
        this.arrayText = text.split("\\*\\*\\*");
    }

    public Document build() throws Exception {
        Document document = new Document();
        Metadata metadata = new GutenbergMetadataExtractor(this.arrayText[0]).getMetadata();
        document.setMetadata(metadata).setContent(this.extractContent());
        return document;
    }

    public String extractContent() {
        String content = this.arrayText[2];
        return content;
    }
}

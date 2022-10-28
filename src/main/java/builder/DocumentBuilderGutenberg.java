package builder;

import java.lang.reflect.InvocationTargetException;

public class DocumentBuilderGutenberg implements DocumentBuilder{

    public String[] arrayText;

    public DocumentBuilderGutenberg(String text){
        this.arrayText = text.split("\\*\\*\\*");
    }

    public Document build() throws Exception {
        Document document = new Document();
        Metadata metadata = new MetadataExtractorGutenberg(this.arrayText[0]).getMetadata();
        document.setMetadata(metadata).setContent(this.extractContent());
        return document;
    }

    public String extractContent() {
        String content = this.arrayText[2];
        return content;
    }
}

package builder;

import java.lang.reflect.InvocationTargetException;

public class DocumentBuilder {

    public String text;

    public DocumentBuilder(String text){
        this.text = text;
    }

    public Document build() throws InvocationTargetException, IllegalAccessException {
        Document document = new Document();
        Metadata metadata = new MetadataExtractorGutenberg(this.text).getMetadata();
        document.setMetadata(metadata).setContent(this.extractContent());
        return document;
    }

    public String extractContent() {
        String content = this.text.split("\\*\\*\\*")[2];
        return content;
    }
}

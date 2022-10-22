package builder;

public class Document {

    private Metadata metadata;
    private String content;

    public Metadata getMetadata() {
        return metadata;
    }

    public String getContent() {
        return content;
    }

    public Document setMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Document setContent(String content) {
        this.content = content;
        return this;
    }
}

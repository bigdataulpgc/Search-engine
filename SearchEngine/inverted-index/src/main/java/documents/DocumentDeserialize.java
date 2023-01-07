package documents;

import documentclasses.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentDeserialize {

    private static final File DATALAKE_FILE = new File("/home/search-engine/disk/datalake/documents");
    private IndexedId indexedId;

    public DocumentDeserialize(IndexedId indexedId) {
        this.indexedId = indexedId;
    }

    public List<Document> getDocuments() {

        List<Document> documents = new ArrayList<>();
        try {
            for (String dateDirectories : DATALAKE_FILE.list()) {

                String actualPath = DATALAKE_FILE + "/" + dateDirectories;
                for (String documentsDirectories : new File(actualPath).list()) {

                    if(indexedId.isIdIndexed(documentsDirectories)) continue;
                    Document document = new DocumentBuilder()
                            .build(actualPath + "/" + documentsDirectories);
                    documents.add(document);
                }
            }
        } catch (Exception ignored) {}
        return documents;
    }
}

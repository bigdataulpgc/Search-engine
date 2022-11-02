package documents;

import classes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDeserialize {

    public static final File DOCUMENT_DIRECTORY = new File("..\\document_datalake");

    public List<Document> getDocuments() throws FileNotFoundException {

        List<Document> documents = new ArrayList<>();
        for (String dateDirectories: DOCUMENT_DIRECTORY.list()) {

            String actualPath =  DOCUMENT_DIRECTORY + "\\" + dateDirectories;
            for (String documentsDirectorys: new File(actualPath).list()) {

                Document document = new DocumentBuilder()
                        .build(actualPath + "\\" + documentsDirectorys);
                documents.add(document);
            }
        }
        return documents;
    }
}

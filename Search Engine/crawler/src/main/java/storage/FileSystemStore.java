package storage;

import classes.Document;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileSystemStore implements DocumentStore {

    private static final String INITIAL_PATH = ".\\document_datalake";

    @Override
    public void store(Document document, int id) {
        JsonMetadataSerializer jsonMetadataSerializer = new JsonMetadataSerializer();
        String metadata = jsonMetadataSerializer.serialize(document.getMetadata());

        String dateString = getDateString();

        String path = INITIAL_PATH + "/" + dateString + "/" + document.getSourceId() + "/";

        new FilePersister(new File(path + document.getSourceId() + ".txt"))
                .persist(document.getContent());

        new FilePersister(new File(path + document.getSourceId() +".json"))
                .persist(metadata);

        createInfoDocument(id, path);
    }

    private static void createInfoDocument(int id, String path) {
        InfoDocument infoDocument = new InfoDocument();
        infoDocument.setId(id).setDate(new Date());
        new FilePersister(new File(path + "info_document.txt"))
                .persist(infoDocument.toString());
    }

    private static String getDateString() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}


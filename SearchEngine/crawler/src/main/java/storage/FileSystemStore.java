package storage;

import documentclasses.Document;
import persistence.FilePersister;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileSystemStore implements DocumentStore {

    private static String INITIAL_PATH = "/home/search-engine/disk/datalake/documents";

    @Override
    public void store(Document document, int id) {
        JsonMetadataSerializer jsonMetadataSerializer = new JsonMetadataSerializer();
        String metadata = jsonMetadataSerializer.serialize(document.getMetadata());

        String dateString = getDateString();

        String path = INITIAL_PATH + "/" + dateString + "/" + document.getSourceId() + "/";

        new FilePersister(new File(path + document.getSourceId() + ".txt"))
                .persist(document.getContent(), true);

        new FilePersister(new File(path + document.getSourceId() +".json"))
                .persist(metadata, true);

        createInfoDocument(id, path);
    }

    private static void createInfoDocument(int id, String path) {
        InfoDocument infoDocument = new InfoDocument();
        infoDocument.setId(id).setDate(new Date());
        new FilePersister(new File(path + "info_document.txt"))
                .persist(infoDocument.toString(), true);
    }

    private static String getDateString() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}


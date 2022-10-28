package file_system;

import classes.Document;

import java.io.File;


public class FileSystemStore implements Store {
    private final String root;

    public FileSystemStore(String root) {
        this.root = root;
    }

    @Override
    public void store(Document document) {
        JsonMetadataSerializer jsonMetadataSerializer = new JsonMetadataSerializer();
        String metadata = jsonMetadataSerializer.serialize(document.getMetadata());

        String path = this.root + "/" + document.getSourceId().substring(0,1) + "/" +document.getSourceId() + "/";

        new FileSystemPersister().persist(create_full_path(path + document.getSourceId() + ".txt"), document.getContent());
        new FileSystemPersister().persist(create_full_path(path + document.getSourceId() +".json"), metadata);
    }

    private File create_full_path(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        return file;

    }
}


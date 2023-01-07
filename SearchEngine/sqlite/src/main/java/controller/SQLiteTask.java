package controller;

import SQLite.SQLiteMetadataManager;
import SQLite.SQLiteMetadataProccesor;
import documentclasses.Metadata;
import documentclasses.MetadataDeserializer;

import java.io.File;
import java.sql.SQLException;
import java.util.TimerTask;

public class SQLiteTask extends TimerTask {

    private static final String PATH_DIRECTORY = "/home/search-engine/disk/datalake/documents";
    private static final InsertedId INSERTED_ID = new InsertedId();


    @Override
    public void run() {

        SQLiteMetadataManager dbManager;
        try {
            dbManager =  new SQLiteMetadataManager().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        if(new File(PATH_DIRECTORY).listFiles(File::isDirectory) != null) {
            for (File dateDirectory : new File(PATH_DIRECTORY).listFiles(File::isDirectory)) {
                for (File directory : dateDirectory.listFiles(File::isDirectory)) {
                    if (INSERTED_ID.isIdIndexed(directory.getName())) continue;
                    newMetadata(directory, dbManager);
                }
            }
        }
    }

    private void newMetadata(File directory, SQLiteMetadataManager dbManager) {
        Metadata metadata = getMetadata(directory);
        try {
            dbManager.insert(metadata, directory.getName());
            INSERTED_ID.addIndexedId(directory.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Metadata getMetadata(File directory) {
        return new MetadataDeserializer().readMetadata(directory);
    }
}

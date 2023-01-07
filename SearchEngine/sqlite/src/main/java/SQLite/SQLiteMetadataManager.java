package SQLite;

import SQLite.operations.SQLiteMetadataCreateTable;
import SQLite.operations.SQLiteMetadataInsertTable;
import SQLite.operations.SQLiteMetadataRead;
import documentclasses.Metadata;
import idmanagment.IdReferences;

import java.io.File;
import java.sql.*;
import java.util.List;


public class SQLiteMetadataManager implements SQLiteDBManager<SQLiteMetadataManager> {


    private static final String PATH = "/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db";
    private static final String DB_PATH = "jdbc:sqlite:" + PATH;
    private static final SQLiteMetadataProccesor sqlDataProcessor = new SQLiteMetadataProccesor();
    private SQLiteMetadataInsertTable SQLiteInsert;
    private SQLiteMetadataRead SQLiteRead;
    private final IdReferences idReferences = new IdReferences();


    @Override
    public SQLiteMetadataManager createTable() throws SQLException {
        Connection connection = this.connect();
        SQLiteMetadataCreateTable SQLiteCreate = new SQLiteMetadataCreateTable(connection);
        SQLiteCreate.create();
        this.SQLiteInsert = new SQLiteMetadataInsertTable(connection);
        this.SQLiteRead = new SQLiteMetadataRead(connection);
        return this;
    }

    private Connection connect() throws SQLException {
        makeDir();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(DB_PATH);
    }

    private static void makeDir() {
        File file = new File(PATH);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }


    @Override
    public SQLiteMetadataManager insert(Metadata metadata, String id) throws SQLException {

        preProcessMetadata(metadata);

        SQLiteInsert.insert(
                idReferences.get(id) + "",
                processAttribute("Language", metadata),
                processAttribute("Title", metadata),
                processAttribute("Author", metadata),
                processAttribute("Release Date", metadata),
                processAttribute("Posting Date", metadata));

        return this;
    }

    private static void preProcessMetadata(Metadata metadata) {
        if (metadataContainsAuthors(metadata)) setAuthor(metadata);
    }

    private static void setAuthor(Metadata metadata) {
        metadata.getMetadata().put("Author", metadata.getMetadata().get("Authors"));
    }

    private static boolean metadataContainsAuthors(Metadata metadata) {
        return metadata.getMetadata().containsKey("Authors");
    }

    private Object processAttribute(String attribute, Metadata metadata){
        if(isNotAttributeOnMetadata(attribute, metadata)) return null;
        return sqlDataProcessor.process(attribute, getAttribute(attribute, metadata));
    }

    private List<String> getAttribute(String attribute, Metadata metadata){
        return metadata.getMetadata().get(attribute);
    }

    private static boolean isNotAttributeOnMetadata(String attribute, Metadata metadata) {
        return metadata.getMetadata().get(attribute) == null;
    }

    @Override
    public SQLiteMetadataManager reader() throws SQLException {
        SQLiteRead.read();
        return this;
    }
}

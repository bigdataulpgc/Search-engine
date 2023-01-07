package SQLite;

import documentclasses.Metadata;

import java.io.IOException;
import java.sql.SQLException;

public interface SQLiteDBManager<Manager extends SQLiteDBManager> {
    Manager createTable() throws IOException, SQLException;
    Manager insert (Metadata metadata, String id) throws SQLException;
    Manager reader() throws SQLException;
}

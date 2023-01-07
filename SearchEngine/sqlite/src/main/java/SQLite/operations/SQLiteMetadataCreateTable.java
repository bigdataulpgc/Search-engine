package SQLite.operations;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteMetadataCreateTable implements SQLiteDBCreate{

    private final Connection connection;

    public SQLiteMetadataCreateTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS metadata (\n"
                + "	id string PRIMARY KEY,\n"
                + "	bookLanguage string,\n"
                + "	title string,\n"
                + "	author string,\n"
                + "	releaseDate date,\n"
                + "	postingDate date\n"
                + ");");
    }
}

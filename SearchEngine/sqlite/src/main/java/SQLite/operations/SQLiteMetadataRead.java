package SQLite.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteMetadataRead implements SQLiteDBRead{

    private final Connection connection;

    public SQLiteMetadataRead(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void read() throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery("SELECT id,bookLanguage,title,author,releaseDate,postingDate FROM metadata");
        while (rs.next()) {
            System.out.println(rs.getString("id") + "\t" +
                    rs.getString("bookLanguage") + "\t" +
                    rs.getString("title") + "\t" +
                    rs.getString("author") + "\t" +
                    rs.getDate("releaseDate"));
        }
    }
}

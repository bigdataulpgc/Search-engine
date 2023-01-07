package SQLite.operations;

import java.sql.*;

public class SQLiteMetadataInsertTable implements SQLiteDBInsert{

    private final PreparedStatement statement;

    public SQLiteMetadataInsertTable(Connection connection) throws SQLException {
        this.statement = createStatement(connection);
    }

    @Override
    public void insert(Object ... objects) throws SQLException {

        for (int index = 0; index < objects.length; index++){
            if (isNull(objects[index])) nullInsertion(index + 1);
            else objectInsertion(objects[index], index + 1);
        }
        statement.execute();

    }

    private PreparedStatement createStatement(Connection connection) throws SQLException {
        return connection.prepareStatement("INSERT INTO metadata(id,bookLanguage,title,author,releaseDate,postingDate) VALUES(?,?,?,?,?,?)");
    }

    private static boolean isNull(Object objects) {
        return objects == null;
    }

    private void nullInsertion(int index) throws SQLException {
        statement.setNull(index, Types.NULL);
    }

    private void objectInsertion(Object object, int index) throws SQLException {
        statement.setObject(index, object);
    }
}

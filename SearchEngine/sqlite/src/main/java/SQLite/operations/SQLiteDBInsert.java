package SQLite.operations;

import java.sql.SQLException;

public interface SQLiteDBInsert {
    void insert(Object[] objects) throws SQLException;
}

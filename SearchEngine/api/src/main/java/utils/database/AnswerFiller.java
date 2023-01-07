package utils.database;

import documentclasses.Metadata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnswerFiller {

    void fill(Map<String, Integer> map, ResultSet result, String parameter) throws SQLException;
    void fill(List<Metadata> setMetadata, ResultSet result) throws SQLException;

}

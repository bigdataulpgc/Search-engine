package utils.database;


import documentclasses.Metadata;

import java.io.File;
import java.sql.*;
import java.util.*;

public class QueryMetadataDatabase implements QueryDatabase {


    private static final AnswerMetadataFiller ANSWER_FILLER = new AnswerMetadataFiller();
    private static final Map<String, String> QUERY_PARAMETER_SQL = new HashMap<>(){{
        put("id", "SELECT * FROM metadata WHERE id = ?");
        put("all", "SELECT * FROM metadata");
    }};

    private static final Map<String, String> QUERY_SQL = new HashMap<>(){{
        put("bookLanguage", "SELECT bookLanguage FROM metadata");
        put("author", "SELECT author FROM metadata");
        put("title", "SELECT title FROM metadata");
        put("year", "SELECT releaseDate FROM metadata");
    }};

    private String DB_PATH = "jdbc:sqlite:";

    public QueryMetadataDatabase(String dbPath){
        DB_PATH += dbPath;
    }

    private Connection connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(DB_PATH);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Metadata> query(String parameter, Object value) {
        List<Metadata> books = new ArrayList<>();
        try (Connection connection = this.connect();
             PreparedStatement statement  = connection.prepareStatement(QUERY_PARAMETER_SQL.get(parameter))){
            if(isValueNotNull(value)) setParameters(value, statement);
            ResultSet result  = statement.executeQuery();
            ANSWER_FILLER.fill(books, result);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    private static void setParameters(Object value, PreparedStatement statement) throws SQLException {
        statement.setObject(1, value);
    }

    private static boolean isValueNotNull(Object value) {
        return value != null;
    }

    @Override
    public Map<String, Integer> query(String parameter) {
        Map<String, Integer> counterBook = new HashMap<>();
        try (Connection connection = this.connect();
             PreparedStatement statement = connection.prepareStatement(QUERY_SQL.get(parameter))) {
            ResultSet result = statement.executeQuery();
            ANSWER_FILLER.fill(counterBook, result, parameter);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return counterBook;
    }
}

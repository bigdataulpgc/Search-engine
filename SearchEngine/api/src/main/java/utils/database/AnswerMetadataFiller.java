package utils.database;

import documentclasses.Metadata;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerMetadataFiller implements AnswerFiller{


    private static final String DATE_COLUMN = "releaseDate";
    private static final String DATE_PARAMETER = "year";

    @Override
    public void fill(Map<String, Integer> map, ResultSet result, String parameter) throws SQLException {
        while (result.next()) {
            if(parameter.equals(DATE_PARAMETER)) updateMap(map, getYear(result.getString(DATE_COLUMN)));
            else updateMap(map, result.getString(parameter));
        }
    }

    private static String getYear(String date) {
        return LocalDate.parse(date).getYear() + "";
    }

    private static void updateMap(Map<String, Integer> map, String value) {
        if(map.containsKey(value)) map.put(value, map.get(value) + 1);
        else map.put(value, 1);
    }

    @Override
    public void fill(List<Metadata> setMetadata, ResultSet result) throws SQLException {
        while (result.next()) {
            Metadata metadata = createMetadata(result);
            setMetadata.add(metadata);
        }
    }

    private Metadata createMetadata(ResultSet result) throws SQLException {
        Map<String, List<String>> metadata = new HashMap<>();

        metadata.put("id", Arrays.asList(result.getString("id")));
        metadata.put("author", Arrays.asList(result.getString("author")));
        metadata.put("title", Arrays.asList(result.getString("title")));
        metadata.put("language", Arrays.asList(result.getString("bookLanguage")));
        metadata.put("posting date", Arrays.asList(result.getString("postingDate")));
        metadata.put("release date", Arrays.asList(result.getString("releaseDate")));

        return new Metadata(metadata);
    }
}

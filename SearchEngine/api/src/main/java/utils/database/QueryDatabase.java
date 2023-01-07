package utils.database;

import documentclasses.Metadata;

import java.util.List;
import java.util.Map;

public interface QueryDatabase {

    List<Metadata> query(String parameter, Object value);
    Map<String, Integer> query(String parameter);
}

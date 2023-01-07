package utils.filter;

import documentclasses.Metadata;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GutenbergDocumentFilter implements DocumentFilter {

    private static final HashMap<String, Comparator> parameterMap =  new HashMap<>(){{

        put("title", (value, key, metadata) -> value.equals(metadata.getMetadata().get(key).get(0)));
        put("language", (value, key, metadata) -> value.equals(metadata.getMetadata().get(key).get(0)));
        put("author", (value, key, metadata) -> {
            for (String metadataValue: metadata.getMetadata().get(key)) {
                if (value.equals(metadataValue)) return true;
            }
            return false;
        });

        put("from", (value, key, metadata) -> LocalDate.parse(value + "-01-01")
                .isBefore(LocalDate.parse(metadata.getMetadata().get("release date").get(0))));

        put("to", (value, key, metadata) -> LocalDate.parse(value + "-12-31")
                .isAfter(LocalDate.parse(metadata.getMetadata().get("release date").get(0))));

    }};

    @Override
    public Set<Metadata> filterBooks(Map<String, String> parameters, Set<Metadata> books){
        for (String key: parameters.keySet()){
            books = books.stream()
                    .filter(book -> parameterMap.get(key).filter(parameters.get(key), key, book))
                    .collect(Collectors.toCollection(HashSet::new));
        }
        return books;
    }

    interface Comparator {
        boolean filter (String value, String key, Metadata metadata);
    }

}
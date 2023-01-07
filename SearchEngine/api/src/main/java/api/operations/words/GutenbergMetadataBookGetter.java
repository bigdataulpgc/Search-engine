package api.operations.words;

import documentclasses.Metadata;
import idmanagment.IdReferences;
import utils.database.QueryMetadataDatabase;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GutenbergMetadataBookGetter implements MetadataBookGetter {

    private static final QueryMetadataDatabase QUERY_DATABASE = new QueryMetadataDatabase("/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db");
    private final IdReferences idReferences = new IdReferences();

    @Override
    public Set<Metadata> getMetadataOfBooks(Set<String> books) {

        Set<Integer> gutenbergBooks = getGutenbergId(books);
        return gutenbergBooks.stream()
                .map(id -> getMetadata(id))
                .collect(Collectors.toCollection(HashSet::new));
    }

    private Metadata getMetadata(int id) {
        return QUERY_DATABASE.query("id", id).get(0);
    }

    private Set<Integer> getGutenbergId(Set<String> books) {
        return books.stream()
                .map(id -> idReferences.get(id))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

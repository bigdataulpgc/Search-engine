package api.operations.stats;

import api.operations.Output;
import api.service.parameter.Parameters;
import documentclasses.Metadata;
import utils.filter.DocumentFilter;
import utils.filter.GutenbergDocumentFilter;
import utils.database.QueryDatabase;
import utils.database.QueryMetadataDatabase;
import java.util.HashSet;
import java.util.Set;


public class CounterStat implements Stat{

    private static final DocumentFilter DOCUMENT_FILTER = new GutenbergDocumentFilter();
    private static final QueryDatabase QUERY_DATABASE = new QueryMetadataDatabase("/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db");


    @Override
    public Output execute(Parameters parameters) {
        Set<Metadata> books = getBooks(parameters);
        return generateOutput(books);
    }


    private Set<Metadata> getBooks(Parameters parameters) {
        Set<Metadata> books = new HashSet<>(QUERY_DATABASE.query("all", null));
        return DOCUMENT_FILTER.filterBooks(parameters.parameters(), books);
    }

    private Output generateOutput(Set<Metadata> books) {
        StatOutput output = new StatOutput();
        return output
                .addResult("Number of books", books.size());
    }

}

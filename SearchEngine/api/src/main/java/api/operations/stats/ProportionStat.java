package api.operations.stats;

import api.operations.Output;
import api.service.parameter.Parameters;
import documentclasses.Metadata;
import utils.database.QueryDatabase;
import utils.database.QueryMetadataDatabase;
import utils.filter.DocumentFilter;
import utils.filter.GutenbergDocumentFilter;

import java.util.HashSet;
import java.util.Set;

public class ProportionStat implements Stat {

    private static final DocumentFilter BOOKS_FILTER = new GutenbergDocumentFilter();
    private static final QueryDatabase QUERY_DATABASE = new QueryMetadataDatabase("/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db");
    private int totalBooks;

    @Override
    public Output execute(Parameters parameters) {
        Set<Metadata> books = getBooks(parameters);
        return generateOutput(books);
    }


    private Set<Metadata> getBooks(Parameters parameters) {
        Set<Metadata> books = new HashSet<>(QUERY_DATABASE.query("all", null));
        totalBooks = books.size();
        return BOOKS_FILTER.filterBooks(parameters.parameters(), books);
    }

    private Output generateOutput(Set<Metadata> books) {
        StatOutput response = new StatOutput();
        return response
                .addResult("Proportion of books", calculateProportion(books) + " %");
    }

    private int calculateProportion(Set<Metadata> books) {
        return Math.round(((float) books.size() / totalBooks) * 100);
    }
}

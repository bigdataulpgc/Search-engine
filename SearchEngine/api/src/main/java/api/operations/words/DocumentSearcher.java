package api.operations.words;

import api.operations.ErrorOutput;
import api.operations.Output;
import api.operations.OperationController;
import api.service.parameter.Parameters;
import documentclasses.Metadata;
import utils.filter.DocumentFilter;
import utils.filter.GutenbergDocumentFilter;

import java.util.*;


public class DocumentSearcher implements OperationController {

    private static final String NAME_PARAMETER = ":words";
    private static final String WORD_BREAKER = "\\+";
    private static final BooksGetter BOOKS_GETTER = new GutenbergBooksGetter();
    private static final DocumentFilter BOOKS_FILTER = new GutenbergDocumentFilter();
    private static final MetadataBookGetter METADATA_BOOK_GETTER = new GutenbergMetadataBookGetter();
    private List<String> words;

    @Override
    public Output getResponse(Parameters parameters) {

        getWords(parameters);
        Set<String> books = BOOKS_GETTER.getBooks(words);
        if(books.isEmpty()) return new ErrorOutput("There is no book with the required words.");
        Set<Metadata> metadataBooks = METADATA_BOOK_GETTER.getMetadataOfBooks(books);
        Set<Metadata> filterBooks = BOOKS_FILTER.filterBooks(parameters.parameters(), metadataBooks);
        if(books.isEmpty()) return new ErrorOutput("There is no book with the required parameters.");
        return generateOutput(filterBooks);
    }

    private Output generateOutput(Set<Metadata> books) {
        DocumentOutput output = new DocumentOutput();
        return output.addWords(new HashSet<>(words))
                .addBooks(books);

    }
    private void getWords(Parameters parameters) {
        words = Arrays.asList(parameters.parameters().remove(NAME_PARAMETER).split(WORD_BREAKER));
    }

}

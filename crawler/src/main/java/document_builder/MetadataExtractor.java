package document_builder;

import java.text.ParseException;

public interface MetadataExtractor {

    Metadata getMetadata();
    void extractTitle();
    void extractAuthors();
    void extractReleaseDate() throws ParseException;
    void extractPostingDate() throws ParseException;
    void extractLanguage();
}

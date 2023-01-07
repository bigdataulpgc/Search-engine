package api.operations.words;

import documentclasses.Metadata;

import java.util.HashSet;
import java.util.Set;

public interface MetadataBookGetter {
    Set<Metadata> getMetadataOfBooks(Set<String> books);
}

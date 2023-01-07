package utils.filter;

import documentclasses.Metadata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface DocumentFilter {

    Set<Metadata> filterBooks(Map<String, String> parameters, Set<Metadata> books);
}

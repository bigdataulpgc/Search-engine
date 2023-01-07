package documents;

import persistence.FilePersister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class IndexedId {

    private static final String PATH = "/home/search-engine/disk/id/indexed_id/indexded_id.tsv";

    private Set<String> indexedId;
    private final FilePersister filePersister;

    public IndexedId() {
        this.filePersister = new FilePersister(new File(PATH)).createDirectory();
        try {
            this.indexedId = readLines(new File(PATH));
        } catch (IOException e) {
            this.indexedId = new HashSet<>();
        }
    }

    private Set<String> readLines(File file) throws IOException {
        java.io.FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Set<String> set = new HashSet<>();
        String linea = bufferedReader.readLine();
        if (Objects.equals(null, linea)) return new HashSet<>();
        Collections.addAll(set, linea.split("\t"));
        return set;
    }

    public void addIndexedId (String id){
        indexedId.add(id);
        filePersister.persist(id + "\t", true);
    }

    public boolean isIdIndexed(String id){
        return indexedId.contains(id);
    }
}

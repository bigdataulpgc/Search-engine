package program;

import program.InvertedIndexPersister;
import java.io.*;
import java.util.List;
import java.util.Map;

public class InvertedIndexStore {

    Map<String, Map<String, List>>  invertedIndex;

    public InvertedIndexStore(Map<String, Map<String, List>>  invertedIndex){
        this.invertedIndex = invertedIndex;
    }
    public void store(String path) {
        invertedIndex.keySet().stream().forEach(word -> {
            File file = create_full_path(path + "/" + word.substring(0,1) + "/" + word + ".tsv");
            invertedIndex.get(word).keySet().stream().forEach(document -> {
                invertedIndex.get(word).get(document).forEach(line -> {
                    new InvertedIndexPersister().persist(file, document + "\t" + line);
                });
            });
        });
    }

    private File create_full_path(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        return file;
    }
}

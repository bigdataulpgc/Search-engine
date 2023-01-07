package inverted_index.storage;

import persistence.FilePersister;
import inverted_index.implementation.MapInvertedIndex;

import java.io.File;
import java.util.List;
import java.util.Map;

public class InvertedIndexStore {

    public static final String INITIAL_PATH = "/home/search-engine/disk/datamart/inverted_index";
    private MapInvertedIndex invertedIndexImplementation;
    private Map<String, Map<String, List<Integer>>> invertedIndex;

    public InvertedIndexStore(MapInvertedIndex invertedIndexImplementation) {
        this.invertedIndexImplementation = invertedIndexImplementation;
        this.invertedIndex = this.invertedIndexImplementation.getInvertedIndex();
    }

    public void store (){
        invertedIndex.keySet().stream().forEach(this::getSerilization);
    }

    private void getSerilization(String word){
        for (String book : invertedIndexImplementation.getBooks(word)) {
            File file = new File(INITIAL_PATH + "/" + word.charAt(0) + "/" + word + "/" + book + ".tsv");
            new FilePersister(file)
                    .persist(invertedIndexImplementation.serialize(word, book), true);
        }
    }
}

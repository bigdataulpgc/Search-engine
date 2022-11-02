package inverted_index.storage;

import storage.FilePersister;
import inverted_index.implementation.MapInvertedIndex;

import java.io.File;
import java.util.List;
import java.util.Map;

public class InvertedIndexStore {

    public static final String INITIAL_PATH = "..\\inverted_index_datalake";
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
        File file = new File(INITIAL_PATH + "/" + word.charAt(0) + "/" + word + ".tsv");
        new FilePersister(file)
                .persist(invertedIndexImplementation.serialize(word));

    }
}

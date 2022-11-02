package inverted_index.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInvertedIndex implements InvertedIndex {

    private Map<String, Map<String, List<Integer>>> invertedIndex;

    public MapInvertedIndex(){
        this.invertedIndex = new HashMap<>();
    }

    public Map<String, Map<String, List<Integer>>> getInvertedIndex() {
        return invertedIndex;
    }

    @Override
    public String serialize(String word) {
        StringBuilder serialized = new StringBuilder();
        for(String documentId: invertedIndex.get(word).keySet()){
            serialized.append(documentId)
                    .append("\t")
                    .append(invertedIndex.get(word).get(documentId).toString())
                    .append("\t");
        }
        return serialized.toString();
    }

    public void setInvertedIndex(Map<String, Map<String, List<Integer>>> invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    @Override
    public void addBook(String word, String id, int nLine) {

        if (isKeyOnMap(invertedIndex, word)) {
            Map<String, List<Integer>> bookMap = invertedIndex.get(word);

            if(isKeyOnMap(bookMap, id)) {
                invertedIndex.get(word).get(id).add(nLine);



            } else {

                List<Integer> lineList = new ArrayList<>();
                lineList.add(nLine);

                invertedIndex.get(word).put(id, lineList);
            }

        } else {
            List<Integer> lineList = new ArrayList<>();
            Map<String, List<Integer>> bookMap = new HashMap<>();

            lineList.add(nLine);
            bookMap.put(id, lineList);
            invertedIndex.put(word, bookMap);
        }
    }
    private boolean isKeyOnMap(Map map, String key){
        return map.containsKey(key);
    }

    @Override
    public String[] getBooks(String word) {
        return (String[]) invertedIndex.get(word).keySet().toArray();
    }

    @Override
    public List<Integer> getLines(String word, String id) {
        return invertedIndex.get(word).get(id);
    }
}

package program;

import com.google.gson.Gson;

import java.util.*;

public class InvertedIndex {

    Map<String, Map<String, List>> invertedIndex;
    public InvertedIndex() {
        this.invertedIndex = new HashMap<>();
    }

    public Map<String, Map<String, List>> getInvertedIndex() {
        return invertedIndex;
    }

    public void setInvertedIndex(Map<String, Map<String, List>> invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    public String serialize() {
        return new Gson().toJson(this.invertedIndex);
    }

    public void addWord(String word, String documentId, int nLine){
        if (this.invertedIndex.containsKey(word)) {
            if (this.invertedIndex.get(word).containsKey(documentId)) {
                this.invertedIndex.get(word).get(documentId).addAll(Arrays.asList(nLine));
            } else {
                this.invertedIndex.get(word).put(documentId, new ArrayList<>(Arrays.asList(nLine)));
            }
        } else {
            Map<String, List> mini = new HashMap<>();
            mini.put(documentId, new ArrayList<>(Arrays.asList(nLine)));
            this.invertedIndex.put(word, mini);
        }
    }
}

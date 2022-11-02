package classes;

import java.util.List;
import java.util.Map;

public class Metadata {

    private Map<String, List<String>> metadata;

    public Metadata(Map<String, List<String>> metadata) {
        this.metadata = metadata;
    }

    public Map<String, List<String>> getMetadata(){
        return this.metadata;
    }
}

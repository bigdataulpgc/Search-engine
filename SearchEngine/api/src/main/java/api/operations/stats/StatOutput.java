package api.operations.stats;

import api.operations.Output;

import java.util.HashMap;
import java.util.Map;

public class StatOutput implements Output {

    private Map<String, Object> result;

    public StatOutput() {
        this.result = new HashMap<>();
    }

    public StatOutput addResult(String key, Object value) {
        this.result.put(key, value);
        return this;
    }
}

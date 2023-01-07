package api.service.parameter;


import java.util.HashMap;

public class Parameters {

    private HashMap<String, String> parameters;

    public Parameters() {
        this.parameters = new HashMap<>();
    }

    public HashMap<String, String> parameters() {
        return parameters;
    }

    public Parameters addParameter(String key, String value){
        this.parameters.put(key, value);
        return this;
    }
}

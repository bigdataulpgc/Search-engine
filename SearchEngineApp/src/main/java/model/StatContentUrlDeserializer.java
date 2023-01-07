package model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

public class StatContentUrlDeserializer implements ContentUrlDeserializer{
    
    
    public String[] dataExtractor(String result) {
        String[] words = new String[100];

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(result, JsonObject.class);

        JsonObject jsonObject = json.getAsJsonObject("result");
        
        int index = 0;
        for (Map.Entry<String, JsonElement> elemento : jsonObject.entrySet()) {
            String clave = elemento.getKey();
            JsonElement valor = elemento.getValue();
            words[index] = clave + ": " + valor;
            index++;
        }
        
        return words;
    }
}

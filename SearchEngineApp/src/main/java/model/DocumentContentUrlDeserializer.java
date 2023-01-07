package model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

public class DocumentContentUrlDeserializer implements ContentUrlDeserializer{
        public String[] dataExtractor(String result) {
        String[] words = new String[100];

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(result, JsonObject.class);

        System.out.println(json);

            JsonArray books = json.getAsJsonArray("books");
            int index = 0;
            for (int i = 0; i < books.size(); i++) {
                JsonObject book = books.get(i).getAsJsonObject();
                JsonObject metadata = book.getAsJsonObject("metadata");
                words[index] = "New Word\n";
                index++;
                for (Map.Entry<String, JsonElement> elemento : metadata.entrySet()) {
                    String clave = elemento.getKey();
                    JsonElement valor = elemento.getValue();
                    words[index] = clave + ": " + valor;
                    index++;
                }
            }

        return words;
    }
}

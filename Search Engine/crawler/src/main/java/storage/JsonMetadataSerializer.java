package storage;

import classes.Metadata;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.time.Instant;

public class JsonMetadataSerializer implements MetadataSerializer {
    @Override
    public String serialize(Metadata metadata) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Instant.class, (JsonSerializer<Instant>) (src, typeOfSrc, context) -> new JsonPrimitive(src.toString())).create();
        return gson.toJson(metadata);
    }
}


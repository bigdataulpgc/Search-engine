package documents;

import classes.Metadata;
import com.google.gson.Gson;

public class JsonMetadataDeserializer {
    public Metadata deserialize(String stringMetadata) {
        return new Gson().fromJson(stringMetadata, Metadata.class);
    }
}

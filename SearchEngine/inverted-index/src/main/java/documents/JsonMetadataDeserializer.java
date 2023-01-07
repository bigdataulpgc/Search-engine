package documents;

import documentclasses.Metadata;
import com.google.gson.Gson;

public class JsonMetadataDeserializer {
    public Metadata deserialize(String stringMetadata) {
        return new Gson().fromJson(stringMetadata, Metadata.class);
    }
}

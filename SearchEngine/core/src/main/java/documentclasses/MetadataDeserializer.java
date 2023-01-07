package documentclasses;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MetadataDeserializer {
    public Metadata readMetadata(File initialPath) {
        try {
            String rawMetadata = new String(Files.readAllBytes(Paths.get(initialPath + "/" + initialPath.getName() + ".json")));
            return extractMetadata(rawMetadata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Metadata extractMetadata(String rawMetadata) {
        return new Gson().fromJson(rawMetadata, Metadata.class);
    }
}

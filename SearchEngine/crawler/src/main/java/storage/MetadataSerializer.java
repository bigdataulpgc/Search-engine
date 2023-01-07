package storage;

import documentclasses.Metadata;

public interface MetadataSerializer {
    String serialize(Metadata metadata);
}

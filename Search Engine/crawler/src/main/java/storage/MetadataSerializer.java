package storage;

import classes.Metadata;

public interface MetadataSerializer {
    String serialize(Metadata metadata);
}

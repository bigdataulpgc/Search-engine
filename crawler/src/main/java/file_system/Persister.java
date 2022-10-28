package file_system;

import java.io.File;
import java.io.IOException;

public interface Persister{
    void persist(File file, String resource) throws IOException;
}


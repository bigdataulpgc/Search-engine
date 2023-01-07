package persistence;

import java.io.File;
import java.io.IOException;

public interface Persister{
    void persist(String resource, boolean append);
}


package model;

import java.io.IOException;

public interface Source {
    String loader(String stat) throws IOException;
}

package persistence;

import java.io.*;

public class FilePersister implements Persister {

    public File file;

    public FilePersister(File file) {
        this.file = file;
        createDirectory();
    }

    @Override
    public void persist(String resource, boolean append) {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, append)))) {
            printWriter.print(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public FilePersister createDirectory() {
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        return this;
    }
}
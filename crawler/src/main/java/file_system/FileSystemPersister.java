package file_system;

import java.io.*;

public class FileSystemPersister implements Persister{

    @Override
    public void persist(File file, String resource) {

        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)) {

            pw.println(resource);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
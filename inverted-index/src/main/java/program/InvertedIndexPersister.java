package program;

import java.io.*;

public class InvertedIndexPersister {
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
